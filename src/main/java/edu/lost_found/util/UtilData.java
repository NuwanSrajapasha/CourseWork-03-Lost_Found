package edu.lost_found.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class UtilData {

    //Generate IDs
    public static String generateUserID(){
        return "U/"+ UUID.randomUUID();
    }

    public static String generateItemID(){
        return "I/"+ UUID.randomUUID();
    }

    public static String generateRequestID(){
        return "R/"+ UUID.randomUUID();
    }

    //Generate current time and date
    public static LocalDate generateDate(){
        return LocalDate.now();
    }
    public static Time generateCurrentTime(){
        return Time.valueOf(LocalTime.now());
    }
}
