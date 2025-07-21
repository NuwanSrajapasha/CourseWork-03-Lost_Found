package edu.lost_found.util;

import java.util.UUID;

public class UtilData {

    public static String generateUserID(){
        return "U-"+ UUID.randomUUID();
    }

    public static String generateItemID(){
        return "I-"+ UUID.randomUUID();
    }

    public static String generateRequestID(){
        return "R-"+ UUID.randomUUID();
    }
}
