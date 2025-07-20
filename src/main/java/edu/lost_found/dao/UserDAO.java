package edu.lost_found.dao;

import edu.lost_found.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByUserEmail(String email);
}
