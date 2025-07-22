package edu.lost_found.entity;

import edu.lost_found.dto.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "request")
public class RequestEntity {
    @Id
    private String requestID;

    private String requestDescription;
    private String requestType;
    private String requestDate;
    private String requestTime;

    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    //One request → one item
    @OneToOne
    @JoinColumn(name = "item_id", unique = true)
    private ItemEntity item;
}
