package edu.lost_found.service.serviceIMPL;

import edu.lost_found.dao.ItemDAO;
import edu.lost_found.dao.RequestDAO;
import edu.lost_found.dao.UserDAO;
import edu.lost_found.dto.RequestDTO;
import edu.lost_found.dto.RequestStatus;
import edu.lost_found.entity.ItemEntity;
import edu.lost_found.entity.RequestEntity;
import edu.lost_found.entity.UserEntity;
import edu.lost_found.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestServiceIMPL implements edu.lost_found.service.RequestService {

    private final RequestDAO requestDAO;
    private final ItemDAO itemDAO;
    private final UserDAO userDAO;

    @Override
    public RequestDTO submitClaimRequest(RequestDTO requestDTO) {
        // ✅ Find the claimant user
        UserEntity claimant = userDAO.findById(requestDTO.getClaimantUserID())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Find the item being claimed
        ItemEntity item = itemDAO.findById(requestDTO.getItemID())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        // ✅ Only FOUND items can be claimed
        if (item.getItemStatus() != edu.lost_found.dto.itemStatus.FOUND) {
            throw new RuntimeException("You can only claim FOUND items!");
        }

        // ✅ Create request entity
        RequestEntity request = new RequestEntity();
        request.setRequestID(UUID.randomUUID().toString());
        request.setRequestDescription(requestDTO.getRequestDescription());
        request.setRequestType(requestDTO.getRequestType());
        request.setRequestDate(LocalDate.parse(LocalDate.now().toString()));
        request.setRequestTime(Time.valueOf(LocalTime.now().toString()));
        request.setRequestStatus(RequestStatus.PENDING);
        request.setItem(item); // ✅ link to item

        // ✅ Save & return DTO
        return toDTO(requestDAO.save(request));
    }

    @Override
    public RequestDTO approveRequest(String requestId) {
        RequestEntity request = requestDAO.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        // ✅ Approve request
        request.setRequestStatus(RequestStatus.APPROVED);

        // ✅ Also mark linked item as CLAIMED
        ItemEntity item = request.getItem();
        item.setItemStatus(edu.lost_found.dto.itemStatus.CLAIMED);
        itemDAO.save(item);

        return toDTO(requestDAO.save(request));
    }

    @Override
    public RequestDTO rejectRequest(String requestId) {
        RequestEntity request = requestDAO.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        // ✅ Reject request
        request.setRequestStatus(RequestStatus.REJECTED);

        // ✅ Item remains FOUND
        return toDTO(requestDAO.save(request));
    }

    @Override
    public void addRequest(RequestDTO requestDTO) {
        requestDTO.setRequestID(UtilData.generateRequestID());
        requestDTO.setRequestDate(LocalDate.parse(String.valueOf(UtilData.generateDate())));
        requestDTO.setRequestTime(Time.valueOf(String.valueOf(UtilData.generateCurrentTime())));
        System.out.println(requestDTO);
    }
    // ✅ Helper: Entity → DTO
    private RequestDTO toDTO(RequestEntity entity) {
        return new RequestDTO(
                entity.getRequestID(),
                entity.getItem() != null ? entity.getItem().getItemID() : null,
                null, // claimantUserID (if needed later)
                entity.getRequestDescription(),
                entity.getRequestType(),
                entity.getRequestDate(),
                entity.getRequestTime(),
                entity.getRequestStatus()
        );
    }


    @Override
    public void updateRequest(String id, RequestDTO requestDTO) {

    }

    @Override
    public void deleteRequest(String requestID) {

    }

    @Override
    public RequestDTO getRequestByID(String requestID) {
        return null;
    }

    @Override
    public List<RequestDTO> getAllRequest() {
        return List.of();
    }


}
