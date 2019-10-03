package by.jnetworks.roadcameraapi.action;

import java.text.ParseException;
import java.util.Date;

import static by.jnetworks.roadcameraapi.constant.Constant.STANDART_FORMAT;

/////////////////////////////////////DONT FORGET ABOUT STRING - IT CAN BE INVALID
public class DateAction {

    public Date convertDate(String dateStr) {

        Date date1 = new Date();

        try {
            date1 = STANDART_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }


}
