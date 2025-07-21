package edu.lost_found.service;

import edu.lost_found.dto.UserDTO;

import java.util.List;

public interface UserService {
    void deleteUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void getSelectedUser(UserDTO userDTO);
    List<UserDTO> getAllUsers(UserDTO userDTO);
}
