package edu.lost_found.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO implements Serializable {
    private String itemID;
    private String requestID;
    private String claimantUserID;
    private String requestDescription;
    private String requestType;
    private String requestDate;
    private String requestTime;
    private RequestStatus requestStatus;

}
