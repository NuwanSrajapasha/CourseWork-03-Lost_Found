package edu.lost_found.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements Serializable {
    private String itemID;
    private String userID;
    private String itemName;
    private String itemDescription;
    private String lostDate;
    private String lostTime;
    private String lostLocation;
    private String itemStatus;

}
