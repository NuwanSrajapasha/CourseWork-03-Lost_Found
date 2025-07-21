package edu.lost_found.controller;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.service.AuthService;
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

    @Autowired
    private UserService userService;

    @GetMapping("health")
    public String healthCheck() {
        return "OK......!!!!!!!";
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("userIDkey") String userID) {
        System.out.println(userID);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{userID}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable String userID,@RequestBody UserDTO userDTO) {
        System.out.println(userID);
        userService.updateUser(userDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable String userID){
        System.out.println("get Selected user"+userID);
        return ResponseEntity.ok(new UserDTO(
        ));

    }
    @GetMapping
    public ResponseEntity<List<UserDTO>>getAllUsers() {
        List<UserDTO> userDTOList =new ArrayList<>();
        return ResponseEntity.ok(userDTOList);
    }
}
