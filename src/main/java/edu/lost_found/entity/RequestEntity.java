package edu.lost_found.entity;

import edu.lost_found.dto.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "request")
public class RequestEntity {
    @Id
    private String requestID;

    private String UserID;
    private String requestDescription;
    private LocalDate requestDate;
    private Time requestTime;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    // One request is linked to ONE user (but one user can have MANY requests)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "userID")
    private UserEntity user;

    //  One request refers to ONE item (one item is linked to ONE request)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "itemID")
    private ItemEntity item;

}
