package by.jnetworks.roadcameraapi.action;


import by.jnetworks.roadcameraapi.validation.IncorrectFormatException;
import net.bytebuddy.implementation.bytecode.Throw;
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

@Service
public abstract class DateAction {
    private static final Logger logger = LogManager.getLogger();

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

    public static boolean isCorrectFormat(String dateStr) {
        Pattern pattern = Pattern.compile(DATE_REGEX, Pattern.CASE_INSENSITIVE);;
        Matcher matcher = pattern.matcher(dateStr);
        return matcher.matches();
    }


}
