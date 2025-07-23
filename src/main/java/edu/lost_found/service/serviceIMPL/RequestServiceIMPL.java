package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dao.ItemDAO;
import edu.lost_found.dao.RequestDAO;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.dto.RequestDTO;
import edu.lost_found.dto.RequestStatus;
import edu.lost_found.entity.ItemEntity;
import edu.lost_found.entity.RequestEntity;
import edu.lost_found.entity.UserEntity;
import edu.lost_found.service.RequestService;
import edu.lost_found.util.EntityDTOConvert;
import edu.lost_found.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class RequestServiceIMPL implements RequestService {

    private final RequestDAO requestDAO;
    private final ItemDAO itemDAO;
    private final UserDAO userDAO;
    private final EntityDTOConvert entityDTOConvert;


    @Override
    public RequestDTO submitClaimRequest(RequestDTO requestDTO) {

        // Convert DTO → Entity
        RequestEntity request = entityDTOConvert.convertRequestDTOToRequestEntity(requestDTO);

        // Load user and item
        UserEntity claimant = userDAO.findById(requestDTO.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ItemEntity item = itemDAO.findById(requestDTO.getItemID())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (item.getItemStatus() != edu.lost_found.dto.itemStatus.FOUND) {
            throw new RuntimeException("You can only claim FOUND items!");
        }

        // IMPORTANT: assign ID before saving
        request.setRequestID(UtilData.generateRequestID());
        request.setUserID(claimant.getUserID());
        request.setRequestDescription(requestDTO.getRequestDescription());
        request.setRequestType(requestDTO.getRequestType());
        request.setRequestDate(UtilData.generateDate());
        request.setRequestTime(UtilData.generateCurrentTime());
        request.setRequestStatus(RequestStatus.PENDING);
        request.setItem(item);

        // Save this same populated object
        RequestEntity saved = requestDAO.save(request);

        return entityDTOConvert.convertRequestEntityToRequestDTO(saved);
    }

    @Override
    public RequestDTO approveRequest(String requestId) {
        // 1️Find request
        RequestEntity request = requestDAO.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        // 2Update status
        request.setRequestStatus(RequestStatus.APPROVED);

        // 3️(Optional) Mark item as claimed if needed
        ItemEntity item = request.getItem();
        if (item != null) {
            item.setItemStatus(edu.lost_found.dto.itemStatus.CLAIMED);
            itemDAO.save(item); // save item update
        }

        // Save updated request
        RequestEntity saved = requestDAO.save(request);

        return entityDTOConvert.convertRequestEntityToRequestDTO(saved);
    }

    @Override
    public RequestDTO rejectRequest(String requestId) {
        // Find request
        RequestEntity request = requestDAO.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        //  Update status
        request.setRequestStatus(RequestStatus.REJECTED);

        //  Save updated request
        RequestEntity saved = requestDAO.save(request);

        return entityDTOConvert.convertRequestEntityToRequestDTO(saved);
    }

    @Override
    public List<RequestDTO> getAllRequest() {
        List<RequestEntity> requests = requestDAO.findAll();
        return entityDTOConvert.toRequestDTOList(requests);
    }
}
