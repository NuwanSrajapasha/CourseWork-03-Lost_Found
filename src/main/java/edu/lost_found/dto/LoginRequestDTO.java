package edu.lost_found.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequestDTO implements Serializable {
    private String userEmail;
    private String userPassword;
}
