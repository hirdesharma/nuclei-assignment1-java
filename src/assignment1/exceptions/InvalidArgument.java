package assignment1.exceptions;

public class InvalidArgument extends RuntimeException {
    public InvalidArgument(String message) {
        super(message);
    }
}