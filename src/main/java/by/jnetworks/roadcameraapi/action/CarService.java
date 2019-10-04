package by.jnetworks.roadcameraapi.action;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.RegisteredCarCount;
import by.jnetworks.roadcameraapi.entity.StoredCar;
import by.jnetworks.roadcameraapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    //done
    public List<RegisteredCar> getAllRegisteredCars() {
        List<StoredCar> storedCarList = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(storedCarList::add);
        List<RegisteredCar> registeredCarList = Converter.convertListToRegisteredCar(storedCarList);
        return registeredCarList;
    }

    //done
    public void addRegisteredCar(RegisteredCar car) {
        String carNumber = car.getCarNumber();
        if (CarFilter.validateCarNumber(carNumber)) {
            car.setTimestamp(OffsetDateTime.now());
            carRepository.save(Converter.convertToStoredCar(car));
        } else {
        System.out.println("False... Illegal format");
        //THROW MY EXCEPTION + log
        }
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
        List<StoredCar> storedCarList = new ArrayList<>();

        carRepository.findAll().forEach(storedCarList::add);
        List<RegisteredCar> registeredCarList = Converter.convertListToRegisteredCar(storedCarList);

        registeredCarList = CarFilter.filterByCarNumber(registeredCarList, carNumber);
        return CarFilter.filterByDate(registeredCarList, date);
    }

}
