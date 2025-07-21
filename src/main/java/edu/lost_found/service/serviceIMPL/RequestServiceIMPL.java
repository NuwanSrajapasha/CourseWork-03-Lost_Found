package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dto.RequestDTO;
import edu.lost_found.dto.RequestStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceIMPL implements edu.lost_found.service.RequestService {
    @Override
    public void addRequest(RequestDTO requestDTO) {

    }

    @Override
    public void updateRequest(String id, RequestDTO requestDTO) {

    }

    @Override
    public void deleteRequest(String requestID) {

    }

    @Override
    public RequestDTO getRequestByID(String requestID) {
        RequestDTO request = new RequestDTO();
        request.setUserID("U0001");
        request.setRequestID("R0001");
        request.setRequestDescription("Request to claim the lost wallet");
        request.setRequestType("CLAIM");
        request.setRequestDate("2025-07-19");
        request.setRequestTime("14:30");
        request.setRequestStatus(String.valueOf(RequestStatus.valueOf("PENDING")));

        return request;
    }

    @Override
    public List<RequestDTO> getAllRequest() {
        return List.of();
    }


}
