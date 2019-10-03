package by.jnetworks.roadcameraapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
public class RegisteredCar {

    @Id
    private String carNumber;
    private OffsetDateTime timestamp;

    public RegisteredCar() {

    }

    public RegisteredCar(String carNumber, OffsetDateTime timestamp) {
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
}
