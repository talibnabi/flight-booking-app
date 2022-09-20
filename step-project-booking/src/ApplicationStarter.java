import console.abstracts.UserMenu;
import console.concretes.FlightBookingMenuManager;
import console.concretes.UserMenuManager;
import exception.*;

public class ApplicationStarter {

    public static void main(String[] args) throws UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        UserMenu userMenu = new UserMenuManager();
        FlightBookingMenuManager flightBookingMenuManager = new FlightBookingMenuManager();
        try {
            userMenu.menu();
        } catch (UserMenuValueNotFoundException | UserPasswordDoesntMatcherException | UserNotFoundException |
                 FlightBookingValueNotFoundException | StringParseException exception) {
            System.out.println(exception.getMessage());
        }
    }
}