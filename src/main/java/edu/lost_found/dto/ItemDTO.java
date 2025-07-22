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
public class ItemDTO implements Serializable {
    private String requestID;
    private String itemID;
    private String itemName;
    private String itemDescription;
    private LocalDate lostDate;
    private Time lostTime;
    private String lostLocation;
    private itemStatus itemStatus;


}
