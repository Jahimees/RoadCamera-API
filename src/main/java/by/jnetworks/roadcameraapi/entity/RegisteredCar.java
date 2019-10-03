package by.jnetworks.roadcameraapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RegisteredCar {

    @Id
    private String carNumber;
    private Date timestamp;

    public RegisteredCar() {

    }

    public RegisteredCar(String carNumber, Date timestamp) {
        this.carNumber = carNumber;
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
