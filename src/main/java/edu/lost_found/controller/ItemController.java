package edu.lost_found.controller;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.entity.ItemEntity;
import edu.lost_found.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/health")
    public String healthCheck() {
        return "Item Controller is loaded!";
    }

    @PostMapping("/lost")
    public ResponseEntity<ItemDTO> reportLostItem(
            @RequestParam String userID,         // user who reported
            @RequestBody ItemDTO itemDTO         // item details
    ) {
        ItemDTO saved = itemService.reportLostItem(userID, itemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{itemID}")
    public ResponseEntity<Void> deleteItem(@PathVariable String itemID) {
        itemService.deleteItem(itemID);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
    @PatchMapping(

            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ItemDTO> updateItemStatus(
            @RequestParam String itemID,
            @RequestBody ItemDTO itemDTO
    ) {
        itemService.updateItem(itemID,itemDTO);
        return ResponseEntity.ok(itemService.getItemById(itemID)); // return updated DTO
    }
    @GetMapping
    public ResponseEntity<ItemDTO> getSelectedID(@RequestParam String itemID) {
        return ResponseEntity.ok(itemService.getItemById(itemID));
    }
    @GetMapping("/lost")
    public ResponseEntity<List<ItemEntity>> getLostItems() {
        return ResponseEntity.ok(itemService.getAllLostItems());
    }   
}
