package edu.lost_found.service;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.dto.UserDTO;
import edu.lost_found.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    ItemEntity markItemClaimed(String itemId);
    void updateItem(String memberID, ItemDTO itemDetails);
    void deleteItem(String memberID);
    ItemDTO getItemById(String memberID);
    List<ItemEntity> getAllLostItems();

    ItemEntity reportLostItem(String userID,ItemDTO itemDTO);
}
