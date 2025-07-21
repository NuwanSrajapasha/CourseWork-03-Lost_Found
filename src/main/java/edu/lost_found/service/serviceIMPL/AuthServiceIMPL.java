package edu.lost_found.service.serviceIMPL;


import edu.lost_found.dto.LoginRequestDTO;
import edu.lost_found.dto.UserRegisterDTO;
import edu.lost_found.entity.User;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.service.AuthService;
import edu.lost_found.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder password;

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setUserName(userRegisterDTO.getUserName());
        user.setEmail(userRegisterDTO.getUserEmail());
        user.setPhone(userRegisterDTO.getUserPhone());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getUserPassword()));
        user.setRole("USER_ROLE");
        userDAO.save(user);
        System.out.println("registered user form service layer"+userRegisterDTO);

    }


    @Override
    public String login(LoginRequestDTO loginRequestDTO) {
        User user = userDAO.findByUserName(loginRequestDTO.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));



        if (passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUserName(), user.getRole());
        }

        throw new RuntimeException("Invalid credentials");

    }


}
