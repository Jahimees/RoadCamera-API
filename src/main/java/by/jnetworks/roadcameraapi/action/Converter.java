package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class Converter {

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
        return registeredCarList;
    }

    public static StoredCar convertToStoredCar(RegisteredCar registeredCar) {
        StoredCar storedCar = new StoredCar();
        storedCar.setCarNumber(registeredCar.getCarNumber());
        storedCar.setTimestamp(registeredCar.getTimestamp());
        return storedCar;
    }
}
