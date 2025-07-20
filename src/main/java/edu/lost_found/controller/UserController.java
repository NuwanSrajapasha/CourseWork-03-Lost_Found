package edu.lost_found.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("health")
    public String healthCheck() {
        return "OK......!!!!!!!";
    }
    public void registerUser(User user) {

    }

}
