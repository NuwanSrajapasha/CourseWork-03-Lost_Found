package edu.lost_found.service;

import edu.lost_found.dto.UserDTO;


public interface AuthService {
    void register(UserDTO userDTO);
    String login(String username, String password);


}
