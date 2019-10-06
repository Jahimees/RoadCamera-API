package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.validation.IncorrectFormatException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateActionTest {
    private String[] dateStrings = {"20201910", "20191012", "19991010", "19999999", "12321"};
    private boolean[] expectedResult = {false, true, true, false, false};
    private String dateStr = "20191019";
    private int dateY = 2019;
    private int dateM = 10;
    private int dateD = 19;


    @Before
    public void beforeTest() {

    }

    @Test
    public void isCorrectFormatTest() {
        boolean[] actualResult = new boolean[dateStrings.length];
        for (int i = 0; i < actualResult.length; i++) {
            actualResult[i] = DateAction.isCorrectFormat(dateStrings[i]);
        }

        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void convertDateTest() {
        OffsetDateTime actualDate = null;
        OffsetDateTime expectedDate =
                OffsetDateTime.of(LocalDateTime.of
                        (2019,10,19,0,0,0), ZoneOffset.ofHoursMinutes(3,00));
        try {
            actualDate = DateAction.convertDate(dateStr);
        } catch (IncorrectFormatException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedDate, actualDate);
    }
}
