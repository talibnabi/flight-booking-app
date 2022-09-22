package exception;

public class AdminNotFoundException extends Exception{
    public AdminNotFoundException() {
        super();
    }

    public AdminNotFoundException(String message) {
        super(message);
    }
}
