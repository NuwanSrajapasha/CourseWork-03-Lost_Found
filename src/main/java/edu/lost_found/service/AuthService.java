package edu.lost_found.service;


import edu.lost_found.dto.LoginRequestDTO;
import edu.lost_found.dto.UserRegisterDTO;

public interface AuthService {
    void register(UserRegisterDTO userRegisterDTO);
    String login(LoginRequestDTO loginRequestDTO);


}
