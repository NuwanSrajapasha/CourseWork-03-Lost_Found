package edu.lost_found.controller;

import edu.lost_found.dto.AuthResponseDTO;
import edu.lost_found.dto.LoginRequestDTO;
import edu.lost_found.dto.UserDTO;
import edu.lost_found.dto.UserRegisterDTO;
import edu.lost_found.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        System.out.println(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered!");

    }
    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        String token = authService.login(loginRequestDTO.getUsernameOrEmail(), loginRequestDTO.getPassword());
        return ResponseEntity.ok(new AuthResponseDTO(token, "ROLE_USER", loginRequestDTO.getUsernameOrEmail()));
    }
}
