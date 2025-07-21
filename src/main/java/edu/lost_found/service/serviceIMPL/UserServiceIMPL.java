package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserDTO getSelectedUser(String userDTO) {
        return (new UserDTO(
                "U1001",                      // userID
                "David Johnson",              // userName
                "david.johnson@example.com",  // userEmail
                "Pass@2025",                  // userPassword
                "+94 761234567",              // userPhone
                "USER"                        // userRole
        ));


    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(
                "U0001",
                "David Johnson",
                "david.johnson@example.com",
                "Pass@2025",
                "+94 761234567",
                "USER"
        ));

        userDTOList.add(new UserDTO(
                "U1002",
                "Emma Williams",
                "emma.williams@example.com",
                "Secure#456",
                "+94 772345678",
                "ADMIN"
        ));

        userDTOList.add(new UserDTO(
                "U1003",
                "Liam Brown",
                "liam.brown@example.com",
                "MyPass789!",
                "+94 773456789",
                "MODERATOR"
        ));
        return userDTOList;
    }
}
