package edu.lost_found.controller;

import edu.lost_found.dao.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("health")
    public String healthCheck() {
        return "OK......!!!!!!!";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO registerUser(UserDTO userDTO) {
        System.out.println(userDTO);
        return userDTO;

    }

}
