package edu.lost_found.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO implements Serializable {
    private String itemID;
    private String requestID;
    private String UserID;
    private String requestDescription;
    private String requestType;
    private LocalDate requestDate;
    private Time requestTime;
    private RequestStatus requestStatus;

}
