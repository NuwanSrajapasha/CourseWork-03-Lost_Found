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

@Service
public class RequestServiceIMPL implements RequestService {

    private final RequestDAO requestDAO;
    private final ItemDAO itemDAO;
    private final UserDAO userDAO;
    private final EntityDTOConvert entityDTOConvert;

    public RequestServiceIMPL(RequestDAO requestDAO, ItemDAO itemDAO, UserDAO userDAO, EntityDTOConvert entityDTOConvert) {
        this.requestDAO = requestDAO;
        this.itemDAO = itemDAO;
        this.userDAO = userDAO;
        this.entityDTOConvert = entityDTOConvert;
    }


    @Override
    public RequestDTO submitClaimRequest(RequestDTO requestDTO) {

        // Convert DTO → Entity
        RequestEntity requestEntity = entityDTOConvert.convertRequestDTOToRequestEntity(requestDTO);
        //  Find the claimant user
        UserEntity claimant = userDAO.findById(requestDTO.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found"));

        //  Find the item being claimed
        ItemEntity item = itemDAO.findById(requestDTO.getItemID())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        //  Only FOUND items can be claimed
        if (item.getItemStatus() != edu.lost_found.dto.itemStatus.FOUND) {
            throw new RuntimeException("You can only claim FOUND items!");
        }

        //  Create request entity
        RequestEntity request = new RequestEntity();
        request.setRequestID(UtilData.generateRequestID());
        request.setRequestDescription(requestDTO.getRequestDescription());
        request.setRequestType(requestDTO.getRequestType());
        request.setRequestDate(LocalDate.parse(LocalDate.now().toString()));
        request.setRequestTime(Time.valueOf(LocalTime.now().toString()));
        request.setRequestStatus(RequestStatus.PENDING);
        request.setItem(item); // ✅ link to item

        // ✅ Save & return DTO
        RequestEntity saved = requestDAO.save(requestEntity);

        //  Convert Entity → DTO for response
        return entityDTOConvert.convertRequestEntityToRequestDTO(saved);
    }

    @Override
    public RequestDTO approveRequest(String requestId) {
        return null;
    }

    @Override
    public RequestDTO rejectRequest(String requestId) {
        return null;
    }

    @Override
    public List<RequestDTO> getAllRequest() {
        return List.of();
    }
}
