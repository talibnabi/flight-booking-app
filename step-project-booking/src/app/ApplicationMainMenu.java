package app;
import console.concretes.FlightBookingMenuManager;
import exception.*;

import static util.MenuUtil.userMenuManager;

public class ApplicationMainMenu {
    public static void showMenuInfo(){
        FlightBookingMenuManager flightBookingMenuManager = new FlightBookingMenuManager();
        try {
            userMenuManager.menu();
        } catch (UserMenuValueNotFoundException | UserPasswordDoesntMatcherException | UserNotFoundException |
                 FlightBookingValueNotFoundException | StringParseException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
