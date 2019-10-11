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

/**
 * CarService class is responsible for executing commands that come from controller
 * {@link by.jnetworks.roadcameraapi.controller.CarController}
 */
@Service
public class CarService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private CarRepository carRepository;

    /**
     * Method adds new car to repository
     * @param car
     */
    public void addRegisteredCar(RegisteredCar car) {
        String carNumber = car.getCarNumber();
        if (CarFilter.validateCarNumber(carNumber)) {
            car.setTimestamp(OffsetDateTime.now());
            carRepository.save(Converter.convertToStoredCar(car));
            logger.info("the car is successfully saved");
        } else {
            logger.error("Illegal carNumber format from POST-request. Actual: "
                    + carNumber + "; Expected-format: [A-Z0-9\\- ]{4,16}");
        }
    }

    /**
     * Method returns object which contain count of registered cars
     * @return RegisteredCarCount
     */
    public RegisteredCarCount getRegisteredCarsCount() {
        RegisteredCarCount registeredCarCount = new RegisteredCarCount();
        registeredCarCount.setRegisteredCarCount(carRepository.count());
        logger.info("Returns count of registered cars...");
        return registeredCarCount;
    }


    /**
     * Method returns cars with concrete carNumber and date
     * @param carNumber
     * @param dateStr
     * @return List<RegisteredCar>
     */
    public List<RegisteredCar> getFilteredRegisteredCars(String carNumber, String dateStr) {
        OffsetDateTime date = null;
        List<RegisteredCar> registeredCarList = new ArrayList<>();
        try {

            List<StoredCar> storedCarList = new ArrayList<>();

            carRepository.findAll().forEach(storedCarList::add);
            registeredCarList = Converter.convertListToRegisteredCar(storedCarList);

            if (carNumber != null) {
                registeredCarList = CarFilter.filterByCarNumber(registeredCarList, carNumber);
                logger.info("Returns filtered registered cars...");
            }
            if (dateStr != null) {
                date = DateAction.convertDate(dateStr);
                registeredCarList = CarFilter.filterByDate(registeredCarList, date);
            }
        } catch (IncorrectFormatException e) {
            logger.error("Input date string has incorrect format. Actual: " + dateStr + "; Expected-format: yyyyMMdd");
        }

        return registeredCarList;
    }

}
