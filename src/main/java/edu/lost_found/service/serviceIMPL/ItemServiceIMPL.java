package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.service.ItemService;
import edu.lost_found.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {


    @Override
    public void addItem(ItemDTO itemDTO) {
        itemDTO.setItemID(UtilData.generateItemID());
        System.out.println(itemDTO);
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
    public List<ItemDTO> getAllItems() {
        return List.of(
                new ItemDTO());
    }
}
