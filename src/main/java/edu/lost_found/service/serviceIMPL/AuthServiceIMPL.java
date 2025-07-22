package edu.lost_found.service.serviceIMPL;


import edu.lost_found.dto.LoginRequestDTO;
import edu.lost_found.dto.Role;
import edu.lost_found.dto.UserRegisterDTO;
import edu.lost_found.entity.UserEntity;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.service.AuthService;
import edu.lost_found.util.JwtUtil;
import edu.lost_found.util.UtilData;
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
        UserEntity userEntity = new UserEntity();
        userEntity.setUserID(UtilData.generateUserID());
        userEntity.setUserName(userRegisterDTO.getUserName());
        userEntity.setEmail(userRegisterDTO.getUserEmail());
        userEntity.setPhone(userRegisterDTO.getUserPhone());
        userEntity.setPassword(passwordEncoder.encode(userRegisterDTO.getUserPassword()));
        userEntity.setRole(Role.valueOf(String.valueOf(userRegisterDTO.getUserRole())));
        userDAO.save(userEntity);
        System.out.println("registered userEntity form service layer"+userRegisterDTO);

    }


    @Override
    public String login(LoginRequestDTO loginRequestDTO) {
        UserEntity userEntity = userDAO.findUserByEmail(loginRequestDTO.getUserEmail())
                .orElseThrow(() -> new RuntimeException("UserEntity not found"));

        if (passwordEncoder.matches(loginRequestDTO.getUserPassword(), userEntity.getPassword())) {
            return jwtUtil.generateToken(userEntity.getUserName(), userEntity.getRole());
        }

        throw new RuntimeException("Invalid credentials");

    }


}
