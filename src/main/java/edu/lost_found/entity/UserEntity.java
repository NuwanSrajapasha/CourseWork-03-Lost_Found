package edu.lost_found.entity;

import edu.lost_found.dto.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    private String userID;
    private String userName;
    private String password;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role; //ADMIN,STAFF,USER

    // One user → many requests
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestEntity> requests;
}
