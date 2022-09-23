package exception;

public class FlightChoiceNotFoundException extends Exception{
    public FlightChoiceNotFoundException() {
        super();
    }

    public FlightChoiceNotFoundException(String message) {
        super(message);
    }
}
