package edu.lost_found.controller;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.service.UserService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("health")
    public String healthCheck() {
        return "OK......!!!!!!!";
    }
    @PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody UserDTO dto) {
        String token = userService.login(dto.getUserName(), dto.getUserPassword());
        return ResponseEntity.ok(token);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("BookIDkey") String userID) {
        System.out.println(userID);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{userID}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable String userID,@RequestBody UserDTO userDTO) {
        System.out.println(userID);
        System.out.println(userDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getSelectedBook(@PathVariable String userID){
        System.out.println("get Selected user"+userID);
        return ResponseEntity.ok(new UserDTO(
        ));

    }
    public ResponseEntity<List<UserDTO >>getAllUsers() {
        List<UserDTO> bookDTOList=new ArrayList<>();
        return ResponseEntity.ok(bookDTOList);
    }
}
