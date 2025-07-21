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

    @GetMapping("health")
    public String healthCheck() {
        return "request health Check OK......!!!!!!!";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addRequest(@RequestBody RequestDTO requestDTO){
        System.out.println(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRequest(@RequestParam("RequestID") String requestID) {
        System.out.println("sucessfuly deleted request "+requestID);
        requestService.deleteRequest(requestID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{requestID}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRequestStatus(@PathVariable String requestID,@RequestBody RequestDTO requestDTO) {
        System.out.println("successful updated "+requestID);
        requestService.updateRequest(requestID,requestDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{requestID}")
    public ResponseEntity<RequestDTO> getSelectedRequest(@PathVariable String requestID) {
        System.out.println("get Selected request "+requestID);
        return new ResponseEntity<>(requestService.getRequestByID(requestID),HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<RequestDTO>>getAllRequests() {
        List<RequestDTO> RequestDTOList=new ArrayList<>();
        return ResponseEntity.ok(RequestDTOList);
    }
}
