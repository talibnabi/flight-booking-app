package exception;

public class FlightIdNotFoundException extends Exception{
    public FlightIdNotFoundException() {
        super();
    }

    public FlightIdNotFoundException(String message) {
        super(message);
    }
}
