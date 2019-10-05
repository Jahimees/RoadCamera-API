package by.jnetworks.roadcameraapi.entity;


import org.apache.catalina.Store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class StoredCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String carNumber;
    private OffsetDateTime timestamp;

    public StoredCar() {

    }

    public StoredCar(String carNumber, OffsetDateTime timestamp) {
        this.carNumber = carNumber;
        this.timestamp = timestamp;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carNumber == null) ? 0 : carNumber.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        StoredCar car = (StoredCar) obj;
        return (this.carNumber == car.getCarNumber()
                || (this.carNumber != null && this.carNumber.equals(car.getCarNumber()))) &&
                (timestamp == car.getTimestamp()
                        || (timestamp != null && timestamp.toString().equals(car.getTimestamp().toString())));
    }

    @Override
    public String toString() {
        return "CarNumber: " + carNumber + "\nTimestamp: " + timestamp.toString();
    }

}
