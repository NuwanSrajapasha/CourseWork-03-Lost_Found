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
    private String requestType;
    private LocalDate requestDate;
    private Time requestTime;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    //One request → one item
    @OneToOne
    @JoinColumn(name = "item_id", unique = true)
    private ItemEntity item;


}
