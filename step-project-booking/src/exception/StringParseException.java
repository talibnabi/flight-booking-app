package exception;

public class StringParseException extends Exception{
    public StringParseException() {
        super();
    }

    public StringParseException(String message) {
        super(message);
    }
}
