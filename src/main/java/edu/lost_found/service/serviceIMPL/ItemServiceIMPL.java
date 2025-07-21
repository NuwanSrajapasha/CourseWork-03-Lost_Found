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
                "I0001",  // itemID
                "U1001",  // userID
                "Black Wallet",  // itemName
                "A black leather wallet with multiple cards and some cash inside.",  // itemDescription
                "2025-07-15",  // lostDate
                "LOST"  // itemStatus
        ));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return List.of(
                new ItemDTO(
                        "I2001",
                        "U1001",
                        "Black Wallet",
                        "A black leather wallet with multiple cards and some cash inside.",
                        "2025-07-15",
                        "LOST"
                ),
                new ItemDTO(
                        "I2002",
                        "U1002",
                        "Silver Bracelet",
                        "A delicate silver bracelet with a heart charm.",
                        "2025-07-10",
                        "FOUND"
                ),
                new ItemDTO(
                        "I2003",
                        "U1003",
                        "Red Backpack",
                        "A red backpack containing books, a laptop, and stationery.",
                        "2025-07-18",
                        "LOST"
                ),
                new ItemDTO(
                        "I2004",
                        "U1004",
                        "iPhone 14 Pro",
                        "A black iPhone 14 Pro with a cracked back cover.",
                        "2025-07-12",
                        "CLAIMED"
                )
        );
    }
}
