package edu.lost_found.controller;

import edu.lost_found.dto.AuthResponseDTO;
import edu.lost_found.dto.LoginRequestDTO;
import edu.lost_found.dto.UserRegisterDTO;
import edu.lost_found.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auths")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> userRegisterDTO(@RequestBody UserRegisterDTO userRegisterDTO) {
        System.out.println(userRegisterDTO);
        authService.register(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("UserEntity registered!");

    }
    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        String token = authService.login(loginRequestDTO);
        return ResponseEntity.ok(new AuthResponseDTO(token, "ROLE_USER", loginRequestDTO.getUserEmail()));
    }

}
