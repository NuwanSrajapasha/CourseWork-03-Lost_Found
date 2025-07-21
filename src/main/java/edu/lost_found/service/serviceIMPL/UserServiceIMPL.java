package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    @Override
    public void deleteUser(UserDTO userDTO) {

    }

    @Override
    public void updateUser(UserDTO userDTO) {

    }

    @Override
    public void getSelectedUser(UserDTO userDTO) {

    }

    @Override
    public List<UserDTO> getAllUsers(UserDTO userDTO) {
        return List.of();
    }
}
