package exception;

public class UserPasswordDoesntMatcherException extends Exception{
    public UserPasswordDoesntMatcherException() {
        super();
    }

    public UserPasswordDoesntMatcherException(String message) {
        super(message);
    }
}
