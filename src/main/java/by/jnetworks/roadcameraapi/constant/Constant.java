package by.jnetworks.roadcameraapi.constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Constant {
    public static final DateFormat ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    public static final DateFormat STANDART_FORMAT = new SimpleDateFormat("yyyyMMdd");

    static {
        ISO_FORMAT.setTimeZone(TimeZone.getTimeZone("Europe/Minsk"));
    }
}
