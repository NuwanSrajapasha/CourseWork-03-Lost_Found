package edu.lost_found.service;

import edu.lost_found.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void reportLostItem(String userId, String itemName);
    void updateItem(String memberID,ItemDTO itemDetails);
    void deleteItem(String memberID);
    ItemDTO getItemById(String memberID);
    List<ItemDTO> getAllItems();
}
