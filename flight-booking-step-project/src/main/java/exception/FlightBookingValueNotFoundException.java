package exception;

public class FlightBookingValueNotFoundException extends Exception{
    public FlightBookingValueNotFoundException() {
        super();
    }

    public FlightBookingValueNotFoundException(String message) {
        super(message);
    }
}
