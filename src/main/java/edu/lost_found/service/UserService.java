package edu.lost_found.service;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.dto.UserDTO;

import java.util.List;

public interface UserService {
    void deleteUser(String userID);
    void updateUser(String userID, UserDTO userDTO);
    UserDTO getSelectedUser(String userID);
    List<UserDTO> getAllUsers();
}
