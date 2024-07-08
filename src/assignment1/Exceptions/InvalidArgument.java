package assignment1.Exceptions;

public class InvalidArgument extends RuntimeException {
    public InvalidArgument(String message) {
        super(message);
    }
}