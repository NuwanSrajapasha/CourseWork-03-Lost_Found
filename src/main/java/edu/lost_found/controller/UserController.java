package edu.lost_found.controller;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("userID") String userID) {
        userService.deleteUser(userID);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{userID}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable String userID,@RequestBody UserDTO userDTO) {
        System.out.println(userID);
        userService.updateUser(userID,userDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<UserDTO> getSelectedUser(@RequestParam String userID){
        return ResponseEntity.ok(userService.getSelectedUser(userID));
    }
    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserDTO>>getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
