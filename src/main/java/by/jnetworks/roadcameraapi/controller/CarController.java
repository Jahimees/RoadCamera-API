package by.jnetworks.roadcameraapi.controller;

import by.jnetworks.roadcameraapi.action.*;
import by.jnetworks.roadcameraapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Standard Spring rest controller class
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * Define "getAll" command
     * @return List<RegisteredCar>
     */
    @RequestMapping("/registeredCars/all")
    public List<RegisteredCar> getAllRegisteredCars() {
        return carService.getAllRegisteredCars();
    }


    /**
     * Takes GET request, which requests data about specific car and date.
     * @param carNumber
     * @param date
     * @return List<RegisteredCar>
     */
    @RequestMapping("/registeredCars")
    public List<RegisteredCar> getFilteredCars(@RequestParam String carNumber, @RequestParam String date) {
        return carService.getFilteredRegisteredCars(carNumber, date);

    }

    /**
     * Takes POST request, which requires add new car with concrete carNumber
     * @param newCar
     */
    @RequestMapping(method = RequestMethod.POST, value = "/registeredCars")
    public void registerCar(@RequestBody RegisteredCar newCar) {
        carService.addRegisteredCar(newCar);
    }

    /**
     * Takes GET request, which requests data about total registered cars count
     * @return RegisteredCarCount
     */
    @RequestMapping("registeredCars/count")
    public RegisteredCarCount getRegisteredCarsCount() {
        return carService.getRegisteredCarsCount();
    }


}
