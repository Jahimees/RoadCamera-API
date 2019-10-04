package by.jnetworks.roadcameraapi.action;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.jnetworks.roadcameraapi.constant.Constant.*;

@Service
public abstract class DateAction {

    public static OffsetDateTime convertDate(String dateStr) {
        OffsetDateTime date = null;
        if (isCorrectFormat(dateStr)) {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(STANDARD_FORMAT)).
                    atStartOfDay(ZoneId.systemDefault()).toOffsetDateTime();
        } else {
            System.out.println("Incorrect date");
            //throw exception
        }
        return date;
    }

    public static boolean isCorrectFormat(String dateStr) {
        Pattern pattern = Pattern.compile(DATE_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(dateStr);
        return matcher.matches();
    }


}
