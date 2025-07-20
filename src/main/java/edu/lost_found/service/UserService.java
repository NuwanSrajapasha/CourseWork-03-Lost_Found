package edu.lost_found.service;

import dto.UserDTO;


public interface UserService {
    void register(UserDTO userDTO);
    String login(String username, String password);
}
