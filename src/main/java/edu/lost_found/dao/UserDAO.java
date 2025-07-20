package edu.lost_found.dao;

import edu.lost_found.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
    Optional<User> findUserByEmail(String email);
}
