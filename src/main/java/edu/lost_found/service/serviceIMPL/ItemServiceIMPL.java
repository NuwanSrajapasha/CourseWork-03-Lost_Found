package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dao.ItemDAO;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.dto.ItemDTO;
import edu.lost_found.dto.UserDTO;
import edu.lost_found.dto.itemStatus;
import edu.lost_found.entity.ItemEntity;
import edu.lost_found.entity.UserEntity;
import edu.lost_found.service.ItemService;
import edu.lost_found.util.EntityDTOConvert;
import jakarta.persistence.EntityManager;
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
    private final UserDAO userDAO;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public ItemEntity reportLostItem(String userID,ItemDTO itemDTO) {
        //Find reporting user
        UserEntity user=userDAO.findById(userID)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        //Create Lost item
        ItemEntity item = new ItemEntity();
        item.setItemID(UUID.randomUUID().toString());
        item.setLostDate(LocalDate.now());
        item.setLostTime(Time.valueOf(LocalTime.now()));
        item.setItemStatus(edu.lost_found.dto.itemStatus.LOST);
        item.setReportedBy(user);

        var itemEntity = entityDTOConvert.convertItemDTOToItemEntity(itemDTO);
        return itemDAO.save(itemEntity);

    }

    @Override
    public ItemEntity markItemClaimed(String itemId) {
        //Fetch item
        ItemEntity item = itemDAO.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        // Only FOUND → CLAIMED allowed
        if (item.getItemStatus() != edu.lost_found.dto.itemStatus.FOUND) {
            throw new RuntimeException("Only FOUND items can be marked CLAIMED");
        }

        item.setItemStatus(edu.lost_found.dto.itemStatus.CLAIMED);
        return itemDAO.save(item);
    }




    @Override
    public void updateItem(String memberID, ItemDTO itemDetails) {

    }

    @Override
    public void deleteItem(String memberID) {

    }

    @Override
    public ItemDTO getItemById(String memberID) {
        return (new ItemDTO(

        ));
    }

    @Override
    public List<ItemEntity> getAllLostItems() {
        // Query LOST items
        return itemDAO.findByItemStatus(itemStatus.LOST);
    }


}
