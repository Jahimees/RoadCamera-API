package by.jnetworks.roadcameraapi.action;


import by.jnetworks.roadcameraapi.validation.IncorrectFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.jnetworks.roadcameraapi.constant.Constant.*;

/**
 * Abstract class which allow parse date from string and validate these string
 */
public final class DateAction {
    private static final Logger logger = LogManager.getLogger();
    private DateAction(){}
    /**
     * Converts date in string to OffsetDateTime object
     * @param dateStr
     * @return OffsetDateTime
     * @throws IncorrectFormatException
     */
    public static OffsetDateTime convertDate(String dateStr) throws IncorrectFormatException {
        OffsetDateTime date = null;
        if (isCorrectFormat(dateStr)) {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(STANDARD_FORMAT)).
                    atStartOfDay(ZoneId.systemDefault()).toOffsetDateTime();
        } else {
            throw new IncorrectFormatException(dateStr + " has incorrect format. Expected format: yyyyMMdd");
        }
        return date;
    }

    /**
     * Define whether the string is correct to convert it
     * @param dateStr
     * @return true - if correct, else - false
     */
    public static boolean isCorrectFormat(String dateStr) {
        Pattern pattern = Pattern.compile(DATE_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(dateStr);
        return matcher.matches();
    }

    /**
     * Converts from OffsetDateTime to String in format "yyyy MM dd"
     * @param offsetDateTime
     * @return String
     */
    public static String convertOffsetDateToString(OffsetDateTime offsetDateTime) {
        return offsetDateTime.getYear() + " " + offsetDateTime.getMonthValue() + " " + offsetDateTime.getDayOfMonth();
    }


}
