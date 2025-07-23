package edu.lost_found.service;

import edu.lost_found.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO reportLostItem(String userID, ItemDTO itemDTO);
    ItemDTO markItemFound(String itemId,ItemDTO itemDTO);
    ItemDTO markItemClaimed(String itemId);
    void updateItem(String itemID, ItemDTO itemDetails);
    void deleteItem(String itemID);
    ItemDTO getItemById(String itemID);
    List<ItemDTO> getAllLostItems();


}
