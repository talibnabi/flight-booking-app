package exception;

public class FlightNotFoundException extends Exception{
    public FlightNotFoundException() {
        super();
    }

    public FlightNotFoundException(String message) {
        super(message);
    }
}
