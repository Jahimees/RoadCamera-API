package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.RegisteredCarCount;
import by.jnetworks.roadcameraapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    //done
    public List<RegisteredCar> getAllRegisteredCars() {
        List<RegisteredCar> registeredCars = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(registeredCars::add);
        return registeredCars;
    }

    //done
    public void addRegisteredCar(RegisteredCar car) {
        carRepository.save(car);
    }

    //done
    public RegisteredCarCount getRegisteredCarsCount() {
        RegisteredCarCount registeredCarCount = RegisteredCarCount.getInstance();
        registeredCarCount.setRegisteredCarCount(carRepository.count());
        return registeredCarCount;
    }


    //done
    public List<RegisteredCar> getFilteredRegisteredCars(String carNumber, String dateStr) {
        OffsetDateTime date = DateAction.convertDate(dateStr);
        List<RegisteredCar> registeredCars = new ArrayList<>();
        carRepository.findAllById(Collections.singleton(carNumber)).forEach(registeredCars::add);
        return filterByDate(registeredCars, date);
    }

    //done
    private List<RegisteredCar> filterByDate(List<RegisteredCar> cars, OffsetDateTime date) {
        int offsetDateValue = date.getMonthValue() + date.getYear() + date.getDayOfMonth();
        for (RegisteredCar car : cars) {
            OffsetDateTime tmpDate = car.getTimestamp();
            int tmpDateValue = tmpDate.getMonthValue() + tmpDate.getYear() + tmpDate.getDayOfMonth();
            if (offsetDateValue != tmpDateValue) {
                cars.remove(car);
            }
        }
        return cars;
    }

}
