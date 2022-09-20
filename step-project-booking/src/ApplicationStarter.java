import app.ApplicationMainMenu;
import exception.*;

public class ApplicationStarter {

    public static void main(String[] args) throws UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        ApplicationMainMenu.showMenuInfo();
    }
}
