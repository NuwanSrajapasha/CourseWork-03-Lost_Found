package edu.lost_found.controller;

import edu.lost_found.dto.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @GetMapping("health")
    public String healthCheck() {
        return "Item health Check OK......!!!!!!!";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addItem(ItemDTO itemDTO){
        System.out.println(itemDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteItem(@RequestParam("ItemIDkey") String userID) {
        System.out.println(userID);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{itemID}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateItemStatus(@PathVariable String itemID,@RequestBody ItemDTO itemDTO) {
        System.out.println(itemID);
        System.out.println(itemDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{itemID}")
    public ResponseEntity<ItemDTO> getSelectedItem(@PathVariable String itemID){
        System.out.println("get Selected item"+itemID);
        return ResponseEntity.ok(new ItemDTO(
        ));

    }
    @GetMapping
    public ResponseEntity<List<ItemDTO>>getAllItems() {
        List<ItemDTO> itemDTOList=new ArrayList<>();
        return ResponseEntity.ok(itemDTOList);
    }
}
