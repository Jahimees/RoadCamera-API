package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter the abstract class which can convert RegisteredCar to StoredCar and StoredCar to RegisteredCar
 */
public final class Converter {
    private static final Logger logger = LogManager.getLogger();
    private Converter(){}

    /**
     * Method converts StoredCar to RegisteredCar
     * @param storedCar
     * @return RegisteredCar
     */
    public static RegisteredCar convertToRegisteredCar(StoredCar storedCar) {
        RegisteredCar registeredCar = new RegisteredCar();
        registeredCar.setTimestamp(storedCar.getTimestamp());
        registeredCar.setCarNumber(storedCar.getCarNumber());
        return registeredCar;
    }

    /**
     * Converts List of StoredCars to List of RegisteredCars
     * @param storedCarList
     * @return List<RegisteredCar>
     */
    public static List<RegisteredCar> convertListToRegisteredCar(List<StoredCar> storedCarList) {
        List<RegisteredCar> registeredCarList = new ArrayList<>();
        for (StoredCar storedCar : storedCarList) {
            registeredCarList.add(convertToRegisteredCar(storedCar));
        }
        logger.info("Stored car list was successfully converted to registered car list");
        return registeredCarList;
    }

    /**
     * Method converts from RegisteredCar to StoredCar
     * @param registeredCar
     * @return StoredCar
     */
    public static StoredCar convertToStoredCar(RegisteredCar registeredCar) {
        StoredCar storedCar = new StoredCar();
        storedCar.setCarNumber(registeredCar.getCarNumber());
        storedCar.setTimestamp(registeredCar.getTimestamp());
        logger.info("Registered car was successfully converted to stored car");
        return storedCar;
    }
}
