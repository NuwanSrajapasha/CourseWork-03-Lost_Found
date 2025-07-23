package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dao.ItemDAO;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.dto.ItemDTO;
import edu.lost_found.dto.itemStatus;
import edu.lost_found.entity.ItemEntity;
import edu.lost_found.service.ItemService;
import edu.lost_found.util.EntityDTOConvert;
import edu.lost_found.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceIMPL implements ItemService {

    private final ItemDAO itemDAO;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public ItemDTO reportLostItem(String userID, ItemDTO itemDTO) {
        // Convert DTO → Entity
        ItemEntity itemEntity = entityDTOConvert.convertItemDTOToItemEntity(itemDTO);

        //  Set LOST metadata
        itemEntity.setItemID(UtilData.generateItemID());
        itemEntity.setRequestID(UtilData.generateRequestID());
        itemEntity.setLostDate(LocalDate.now());
        itemEntity.setLostTime(Time.valueOf(LocalTime.now()));
        itemEntity.setItemStatus(itemStatus.LOST);

        // Save LOST item
        ItemEntity saved = itemDAO.save(itemEntity);

        //  Convert Entity → DTO for response
        return entityDTOConvert.convertItemEntityToItemDTO(saved);
    }

    @Override
    public ItemDTO markItemFound(String itemId,ItemDTO itemDTO) {
        //  Fetch item
        ItemEntity item = itemDAO.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        //  Only LOST → FOUND allowed
        if (item.getItemStatus() != itemStatus.LOST) {
            throw new RuntimeException("Only LOST items can be marked FOUND");
        }

        item.setItemStatus(itemStatus.FOUND);

        //  Save updated
        ItemEntity saved = itemDAO.save(item);

        // Convert → DTO
        return entityDTOConvert.convertItemEntityToItemDTO(saved);
    }

    @Override
    public ItemDTO markItemClaimed(String itemId) {
        //  Fetch item
        ItemEntity item = itemDAO.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        //  Only FOUND → CLAIMED allowed
        if (item.getItemStatus() != itemStatus.FOUND) {
            throw new RuntimeException("Only FOUND items can be marked CLAIMED");
        }

        item.setItemStatus(itemStatus.CLAIMED);

        // Save updated
        ItemEntity saved = itemDAO.save(item);

        //  Convert → DTO
        return entityDTOConvert.convertItemEntityToItemDTO(saved);

    }


    @Override
    public void updateItem(String itemID, ItemDTO itemDTO) {
        ItemEntity item = itemDAO.findById(itemDTO.getItemID())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        // Only update status
        if (itemDTO.getItemStatus() != null) {
            item.setItemStatus(itemDTO.getItemStatus());
        }

        itemDAO.save(item);
    }

    @Override
    public void deleteItem(String itemID) {
        itemDAO.deleteById(itemID);
    }

    @Override
    public ItemDTO getItemById(String itemID) {
        ItemEntity item = itemDAO.findById(itemID)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return entityDTOConvert.convertItemEntityToItemDTO(item);
    }

    @Override
    public List<ItemEntity> getAllLostItems() {

        return itemDAO.findByItemStatus(itemStatus.LOST);
    }


}
