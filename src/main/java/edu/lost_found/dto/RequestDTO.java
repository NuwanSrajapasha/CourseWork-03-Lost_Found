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
    private String LinkeditemID;
    private String requestID;
    private String UserID;
    private String requestDescription;
    private LocalDate requestDate;
    private Time requestTime;
    private RequestStatus requestStatus;

}
