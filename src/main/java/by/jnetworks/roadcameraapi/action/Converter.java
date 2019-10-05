package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class Converter {
    private static final Logger logger = LogManager.getLogger();

    public static RegisteredCar convertToRegisteredCar(StoredCar storedCar) {
        RegisteredCar registeredCar = new RegisteredCar();
        registeredCar.setTimestamp(storedCar.getTimestamp());
        registeredCar.setCarNumber(storedCar.getCarNumber());
        return registeredCar;
    }

    public static List<RegisteredCar> convertListToRegisteredCar(List<StoredCar> storedCarList) {
        List<RegisteredCar> registeredCarList = new ArrayList<>();
        for (StoredCar storedCar : storedCarList) {
            registeredCarList.add(convertToRegisteredCar(storedCar));
        }
        logger.info("Stored car list was successfully converted to registered car list");
        return registeredCarList;
    }

    public static StoredCar convertToStoredCar(RegisteredCar registeredCar) {
        StoredCar storedCar = new StoredCar();
        storedCar.setCarNumber(registeredCar.getCarNumber());
        storedCar.setTimestamp(registeredCar.getTimestamp());
        logger.info("Registered car was successfully converted to stored car");
        return storedCar;
    }
}
