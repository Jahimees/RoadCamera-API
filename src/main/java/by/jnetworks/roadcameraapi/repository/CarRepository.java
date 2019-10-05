package by.jnetworks.roadcameraapi.repository;

import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository
 */
public interface CarRepository extends CrudRepository<StoredCar, String> {
}
