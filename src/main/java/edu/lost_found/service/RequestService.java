package edu.lost_found.service;

import edu.lost_found.dto.RequestDTO;

import java.util.List;

public interface RequestService {
    RequestDTO submitClaimRequest(RequestDTO requestDTO);
    RequestDTO approveRequest(String requestId);
    RequestDTO rejectRequest(String requestId);
    void addRequest(RequestDTO requestDTO);
    void updateRequest(String requestID,RequestDTO requestDTO);
    void deleteRequest(String requestID);
    RequestDTO getRequestByID(String requestID);
    List<RequestDTO> getAllRequest();
}
