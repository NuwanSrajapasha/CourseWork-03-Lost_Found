package edu.lost_found.controller;

import edu.lost_found.dao.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("health")
    public String healthCheck() {
        return "OK......!!!!!!!";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
