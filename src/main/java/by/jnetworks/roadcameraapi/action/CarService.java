package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.RegisteredCarCount;
import by.jnetworks.roadcameraapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    //done but remember about date-format
    public void addRegisteredCar(RegisteredCar car) {
        carRepository.save(car);
    }

    //done
    public RegisteredCarCount getRegisteredCarsCount() {
        RegisteredCarCount registeredCarCount = RegisteredCarCount.getInstance();
        registeredCarCount.setRegisteredCarCount(carRepository.count());
        return registeredCarCount;
    }


    ////////////////////////////////THINK ABOUT DATE
//    public List<RegisteredCar> getFilteredRegisteredCars(String carNumber, String dateStr) {
//        DateAction dateAction = new DateAction();
//        Date date = dateAction.convertDate(dateStr);
//        List<RegisteredCar> registeredCars = new ArrayList<>();
//        carRepository.findAllById(Collections.singleton(carNumber)).forEach(registeredCars::add);
//
//    }

    ////////////////////////////////THINK ABOUT DATE
//    public List<RegisteredCar> filterByDate(List<RegisteredCar> cars, Date date) {
//        for (RegisteredCar car : cars) {
//            Date tmpDate = car.getTimestamp();
//            if (tmpDate.get)
//        }
//    }

}
