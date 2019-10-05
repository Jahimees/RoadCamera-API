package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.OffsetDateTime;

public class ConverterTest {
    private StoredCar storedCar = new StoredCar();
    private  RegisteredCar registeredCar = new RegisteredCar();


    @Before
    public void beforeTest(){
        storedCar.setCarNumber("93pds");
        storedCar.setTimestamp(OffsetDateTime.now());

        registeredCar.setCarNumber("237jds");
        registeredCar.setTimestamp(OffsetDateTime.now());
    }

    @Test
    public void convertToRegisteredCarTest(){
        RegisteredCar actualRegisteredCar = Converter.convertToRegisteredCar(storedCar);
        RegisteredCar expectedRegisteredCar = new RegisteredCar();
        expectedRegisteredCar.setCarNumber(storedCar.getCarNumber());
        expectedRegisteredCar.setTimestamp(storedCar.getTimestamp());
        Assert.assertEquals(expectedRegisteredCar, actualRegisteredCar);
    }

    @Test
    public void convertToStoredCarTest() {
        StoredCar actualStoredCar = Converter.convertToStoredCar(registeredCar);
        StoredCar expectedStoredCar = new StoredCar();
        expectedStoredCar.setCarNumber(registeredCar.getCarNumber());
        expectedStoredCar.setTimestamp(registeredCar.getTimestamp());
        Assert.assertEquals(expectedStoredCar, actualStoredCar);
    }

}
