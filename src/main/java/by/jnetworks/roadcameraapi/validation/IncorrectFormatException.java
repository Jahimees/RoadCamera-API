package by.jnetworks.roadcameraapi.validation;

/**
 * Exception class throws when input data has invalid format
 */
public class IncorrectFormatException extends Exception {

    public IncorrectFormatException(String message) {
        super("Input data has incorrect format: " + message);
    }
}
