package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CarFilterTest {
    private List<RegisteredCar> registeredCarList;
    private List<RegisteredCar> filteredCarsByCarNumber;
    private List<RegisteredCar> expectedListByCarNumber;
    private String[] exampleCarNumbers = {"5p-9c","5p","5p9c","sp-9c","9c"};
    private boolean[] expectedCarNumberValidate = {true, false,true,true,false};
    private boolean[] actualCarNumberValidate;

    @Before
    public void beforeTest() {
        registeredCarList = new ArrayList<>(Arrays.asList(
                new RegisteredCar("5p-9c", OffsetDateTime.now()),
                new RegisteredCar("4a-1c", OffsetDateTime.now()),
                new RegisteredCar("7g-1c", OffsetDateTime.now()),
                new RegisteredCar("5p-9c", OffsetDateTime.now()),
                new RegisteredCar("3p-5c", OffsetDateTime.now())
        ));
        expectedListByCarNumber = new ArrayList<>(Arrays.asList(
                new RegisteredCar("5p-9c", OffsetDateTime.now()),
                new RegisteredCar("5p-9c", OffsetDateTime.now())
        ));
        actualCarNumberValidate = new boolean[exampleCarNumbers.length];

    }

    @Test
    public void filterByCarNumberTest() {
        filteredCarsByCarNumber = CarFilter.filterByCarNumber(registeredCarList, "5p-9c");
        String[] filteredCarNumbers = new String[filteredCarsByCarNumber.size()];
        String[] expectedCarNumbers = new String[expectedListByCarNumber.size()];
        for (int i = 0; i < filteredCarNumbers.length; i++) {
            filteredCarNumbers[i] = filteredCarsByCarNumber.get(i).getCarNumber();
        }
        for (int i = 0; i < expectedCarNumbers.length; i++) {
            expectedCarNumbers[i] = expectedListByCarNumber.get(i).getCarNumber();
        }
        Assert.assertArrayEquals(expectedCarNumbers, filteredCarNumbers);
    }

    @Test
    public void validateCarNumberTest() {
        for (int i = 0; i< actualCarNumberValidate.length; i++) {
            actualCarNumberValidate[i] = CarFilter.validateCarNumber(exampleCarNumbers[i]);
        }
        Assert.assertArrayEquals(expectedCarNumberValidate, actualCarNumberValidate);
    }
}
