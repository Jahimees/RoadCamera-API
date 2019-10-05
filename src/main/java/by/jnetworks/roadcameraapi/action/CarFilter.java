package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.jnetworks.roadcameraapi.constant.Constant.CAR_NUMBER_REGEX;

/**
 * Abstract class which filter cars by different parameters
 */
@Service
public abstract class CarFilter {
    private static final Logger logger = LogManager.getLogger();

    /**
     * Filter input Registered car list by carNumber and return list of cars which has defined carNumber
     * @param cars
     * @param carNumber
     * @return List<RegisteredCar>
     */
    public static List<RegisteredCar> filterByCarNumber(List<RegisteredCar> cars, String carNumber) {
        List<RegisteredCar> filteredCars = new ArrayList<>();
        for (RegisteredCar car : cars) {
            if (car.getCarNumber().equals(carNumber)) {
                filteredCars.add(car);
            }
        }
        logger.info("Cars was successfully filtered (by car number)");
        return filteredCars;
    }

    /**
     * Filter input Registered car list by OffsetDateTime and return list of cars which has defined date
     * @param cars
     * @param date
     * @return List<RegisteredCar>
     */
    public static List<RegisteredCar> filterByDate(List<RegisteredCar> cars, OffsetDateTime date) {
        String offsetDateValue = date.getYear() + " " + date.getMonthValue() + " " + date.getDayOfMonth();
        List<RegisteredCar> filteredCars = new ArrayList<>();
        for (RegisteredCar car : cars) {
            OffsetDateTime tmpDate = car.getTimestamp();
            String tmpDateValue = tmpDate.getYear() + " " + tmpDate.getMonthValue() + " " + tmpDate.getDayOfMonth();
            if (offsetDateValue.equals(tmpDateValue)) {
                filteredCars.add(car);
            }
        }
        logger.info("Cars was successfully filtered (by date)");
        return filteredCars;
    }

    /**
     * Validate input carNumber for well format
     * @param carNumber
     * @return true - if carNumber is valid, else - false
     */
    public static boolean validateCarNumber(String carNumber) {
        Pattern pattern = Pattern.compile(CAR_NUMBER_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(carNumber);
        return matcher.matches();
    }
}
