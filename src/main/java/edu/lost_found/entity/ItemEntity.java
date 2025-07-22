package edu.lost_found.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    private String itemID;

    private String itemName;
    private String itemDescription;
    private LocalDate lostDate;
    private Time lostTime;
    private String lostLocation;

    @Enumerated(EnumType.STRING)
    private edu.lost_found.dto.itemStatus itemStatus;

    // Many items → one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // FK in items table
    private UserEntity reportedBy;

    // One item → one request
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private RequestEntity requestEntity;

}
