package by.jnetworks.roadcameraapi.controller;

import by.jnetworks.roadcameraapi.action.CarService;
import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import by.jnetworks.roadcameraapi.entity.RegisteredCarCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    //done
    @RequestMapping("/registeredCarsAll")
    public List<RegisteredCar> getAllRegisteredCars() {
        return carService.getAllRegisteredCars();
    }


    //done
    @RequestMapping("/registeredCars")
    public List<RegisteredCar> getFilteredCars(@RequestParam String carNumber, @RequestParam String date) {
        return carService.getFilteredRegisteredCars(carNumber, date);

    }

    //REGEX ON ID!!!!!
    @RequestMapping(method = RequestMethod.POST, value = "/registeredCars")
    public void registerCar(@RequestBody RegisteredCar newCar) {
        newCar.setTimestamp(OffsetDateTime.now()); //regex on id
        carService.addRegisteredCar(newCar);
    }

    //done
    @RequestMapping("registeredCars/count")
    public RegisteredCarCount getRegisteredCarsCount() {
        return carService.getRegisteredCarsCount();
    }


}
