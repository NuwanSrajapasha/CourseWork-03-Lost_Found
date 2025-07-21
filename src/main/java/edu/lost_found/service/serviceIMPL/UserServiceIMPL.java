package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.entity.User;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.config.AppConfig;
import edu.lost_found.service.UserService;
import edu.lost_found.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public void register(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getUserEmail());
        user.setRole("USER_ROLE");
        user.setPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        userDAO.save(user);
    }

    @Override
    public String login(String username, String password) {
        User user = userDAO.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getUserName(), user.getRole());
    }

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
