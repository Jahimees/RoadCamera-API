package by.jnetworks.roadcameraapi.action;


import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static by.jnetworks.roadcameraapi.constant.Constant.STANDARD_FORMAT;

/////////////////////////////////////DONT FORGET ABOUT STRING - IT CAN BE INVALID
public abstract class DateAction {

    public static OffsetDateTime convertDate(String dateStr) {
        OffsetDateTime date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(STANDARD_FORMAT)).
                atStartOfDay(ZoneId.systemDefault()).toOffsetDateTime();
        return date;
    }


}
