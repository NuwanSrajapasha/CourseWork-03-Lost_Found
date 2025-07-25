package edu.lost_found.dao;

import edu.lost_found.dto.UserDTO;
import edu.lost_found.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUserID(UserDTO userDTO);
    Optional<UserEntity> findByUserName(String usernameOrEmail);
    Optional<UserEntity> findUserByEmail(String email);
}
