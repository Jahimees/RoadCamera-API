package by.jnetworks.roadcameraapi.validation;

public class IncorrectFormatException extends Exception {

    public IncorrectFormatException(String message) {
        super("Input data has incorrect format: " + message);
    }
}
