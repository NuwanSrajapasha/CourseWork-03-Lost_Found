package edu.lost_found.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private String userID;
    private String itemID;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhone;
    private Role userRole;
}
