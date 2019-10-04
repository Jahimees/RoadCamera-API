package by.jnetworks.roadcameraapi.repository;

import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<StoredCar, String> {
}
