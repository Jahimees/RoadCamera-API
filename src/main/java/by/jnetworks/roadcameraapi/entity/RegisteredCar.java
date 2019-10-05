package by.jnetworks.roadcameraapi.entity;

import java.time.OffsetDateTime;

/**
 * Entity which sends like response
 */
public class RegisteredCar {

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

        RegisteredCar car = (RegisteredCar) obj;
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
