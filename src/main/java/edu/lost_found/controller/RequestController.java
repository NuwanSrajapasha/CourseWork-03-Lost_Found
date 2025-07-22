package edu.lost_found.controller;

import edu.lost_found.dto.RequestDTO;
import edu.lost_found.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;


    // User submits a claim
    @PostMapping("/claim")
    public ResponseEntity<RequestDTO> submitClaim(@RequestBody RequestDTO dto) {
        return ResponseEntity.ok(requestService.submitClaimRequest(dto));
    }

    // Staff approves claim
    @PutMapping("/{requestId}/approve")
    public ResponseEntity<RequestDTO> approve(@PathVariable String requestId) {
        return ResponseEntity.ok(requestService.approveRequest(requestId));
    }

    // Staff rejects claim
    @PutMapping("/{requestId}/reject")
    public ResponseEntity<RequestDTO> reject(@PathVariable String requestId) {
        return ResponseEntity.ok(requestService.rejectRequest(requestId));
    }


    @GetMapping
    public ResponseEntity<List<RequestDTO>>getAllRequests() {
        List<RequestDTO> RequestDTOList=new ArrayList<>();
        return ResponseEntity.ok(RequestDTOList);
    }
}
