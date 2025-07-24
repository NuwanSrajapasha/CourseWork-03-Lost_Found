package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dao.UserDAO;
import edu.lost_found.dto.UserDTO;
import edu.lost_found.entity.UserEntity;
import edu.lost_found.service.UserService;
import edu.lost_found.util.EntityDTOConvert;
import edu.lost_found.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final UserDAO userDAO;
    private final EntityDTOConvert entityDTOConvert;


    @Override
    public void addUser(UserDTO userDTO) {
        // Generate unique user ID
        userDTO.setUserID(UtilData.generateUserID());

        // Convert DTO → Entity
        UserEntity userEntity = entityDTOConvert.convertUserDTOToUserEntity(userDTO);

        // Save in DB
        userDAO.save(userEntity);

    }

    @Override
    public void deleteUser(String userID) {
        if (!userDAO.existsById(userID)) {
            throw new RuntimeException("User not found!");
        }
        userDAO.deleteById(userID);

    }

    @Override
    public void updateUser(String userID, UserDTO userDTO) {
        // Find existing user
        UserEntity existingUser = userDAO.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Update fields
        existingUser.setUserName(userDTO.getUserName());
        existingUser.setEmail(userDTO.getUserEmail());
        existingUser.setPassword(userDTO.getUserPassword());
        existingUser.setPhone(userDTO.getUserPhone());
        existingUser.setRole(userDTO.getUserRole());

        // Save updated user
        userDAO.save(existingUser);


    }


    @Override
    public UserDTO getSelectedUser(String userID) {
        UserEntity userEntity = userDAO.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        return entityDTOConvert.convertUserEntityToUserDTO(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntities = userDAO.findAll();
        return entityDTOConvert.toUserDTOList(userEntities);
    }
}
