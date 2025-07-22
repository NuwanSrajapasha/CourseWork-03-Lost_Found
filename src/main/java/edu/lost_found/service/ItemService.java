package edu.lost_found.service;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    ItemDTO reportLostItem(String userID, ItemDTO itemDTO);
    ItemDTO markItemFound(String itemId);
    ItemDTO markItemClaimed(String itemId);
    void updateItem(String memberID, ItemDTO itemDetails);
    void deleteItem(String memberID);
    ItemDTO getItemById(String memberID);
    List<ItemEntity> getAllLostItems();


}
