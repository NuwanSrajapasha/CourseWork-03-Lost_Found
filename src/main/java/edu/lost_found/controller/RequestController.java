package edu.lost_found.controller;

import edu.lost_found.dto.ItemDTO;
import edu.lost_found.dto.RequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/request")
public class RequestController {
    @GetMapping("health")
    public String healthCheck() {
        return "request health Check OK......!!!!!!!";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addRequest(ItemDTO itemDTO){
        System.out.println(itemDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRequest(@RequestParam("RequestIDkey") String requestID) {
        System.out.println(requestID);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping(value = "/{requestID}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRequestStatus(@PathVariable String requestID,@RequestBody RequestDTO requestDTO) {
        System.out.println(requestID);
        System.out.println(requestDTO);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{requestID}")
    public ResponseEntity<RequestDTO> getSelectedRequest(@PathVariable String requestID) {
        System.out.println("get Selected request"+requestID);
        return ResponseEntity.ok(new RequestDTO());

    }
    @GetMapping
    public ResponseEntity<List<RequestDTO>>getAllRequests() {
        List<RequestDTO> RequestDTOList=new ArrayList<>();
        return ResponseEntity.ok(RequestDTOList);
    }
}
