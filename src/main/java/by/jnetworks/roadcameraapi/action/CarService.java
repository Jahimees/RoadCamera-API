package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.RegisteredCarCount;
import by.jnetworks.roadcameraapi.entity.StoredCar;
import by.jnetworks.roadcameraapi.repository.CarRepository;
import by.jnetworks.roadcameraapi.validation.IncorrectFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private CarRepository carRepository;

    //done
    public List<RegisteredCar> getAllRegisteredCars() {
        List<StoredCar> storedCarList = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(storedCarList::add);
        List<RegisteredCar> registeredCarList = Converter.convertListToRegisteredCar(storedCarList);
        logger.info("Returns all registered cars...");
        return registeredCarList;
    }

    //done
    public void addRegisteredCar(RegisteredCar car) {
        String carNumber = car.getCarNumber();
        if (CarFilter.validateCarNumber(carNumber)) {
            car.setTimestamp(OffsetDateTime.now());
            carRepository.save(Converter.convertToStoredCar(car));
            logger.info("the car is successfully saved");
        } else {
            logger.error("Illegal carNumber format from POST-query. Actual: "
                    + carNumber + "; Expected-format: [A-Z0-9\\- ]{4,16}");
        }
    }

    //done
    public RegisteredCarCount getRegisteredCarsCount() {
        RegisteredCarCount registeredCarCount = RegisteredCarCount.getInstance();
        registeredCarCount.setRegisteredCarCount(carRepository.count());
        logger.info("Returns count of registered cars...");
        return registeredCarCount;
    }


    //done
    public List<RegisteredCar> getFilteredRegisteredCars(String carNumber, String dateStr) {
        OffsetDateTime date = null;
        List<RegisteredCar> registeredCarList = new ArrayList<>();
        try {
            date = DateAction.convertDate(dateStr);
            List<StoredCar> storedCarList = new ArrayList<>();

            carRepository.findAll().forEach(storedCarList::add);
            registeredCarList = Converter.convertListToRegisteredCar(storedCarList);

            registeredCarList = CarFilter.filterByCarNumber(registeredCarList, carNumber);
            logger.info("Returns filtered registered cars...");
            registeredCarList = CarFilter.filterByDate(registeredCarList, date);
        } catch (IncorrectFormatException e) {
            logger.error("Input date string has incorrect format. Actual: " + dateStr + "; Expected-format: yyyyMMdd");
        }

        return registeredCarList;
    }

}
