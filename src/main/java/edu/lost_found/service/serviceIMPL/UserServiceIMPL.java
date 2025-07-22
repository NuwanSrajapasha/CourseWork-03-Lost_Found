package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.service.UserService;
import edu.lost_found.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {


    @Override
    public void addUser(UserDTO userDTO) {
        //Business process
        userDTO.setUserID(UtilData.generateUserID());
        System.out.println(userDTO);

    }

    @Override
    public void deleteUser(String userID) {

    }

    @Override
    public void updateUser(String userID, UserDTO userDTO) {

    }



    @Override
    public UserDTO getSelectedUser(String userDTO) {
        return (new UserDTO(

        ));


    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(

        ));

        userDTOList.add(new UserDTO(

        ));

        userDTOList.add(new UserDTO(

        ));
        return userDTOList;
    }
}
