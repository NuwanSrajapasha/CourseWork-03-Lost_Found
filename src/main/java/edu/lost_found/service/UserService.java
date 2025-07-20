package edu.lost_found.service;

import edu.lost_found.dto.UserDTO;


public interface UserService {
    void register(UserDTO userDTO);
    String login(String username, String password);
}
