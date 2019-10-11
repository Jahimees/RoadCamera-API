package by.jnetworks.roadcameraapi.repository;

import by.jnetworks.roadcameraapi.entity.StoredCar;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository
 */
public interface CarRepository extends PagingAndSortingRepository<StoredCar, String> {
}
