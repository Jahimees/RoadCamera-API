package by.jnetworks.roadcameraapi.repository;

import by.jnetworks.roadcameraapi.entity.RegisteredCar;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<RegisteredCar, String> {
}
