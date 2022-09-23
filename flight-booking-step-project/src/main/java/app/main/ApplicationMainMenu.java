package app.main;
import exception.*;

import static util.MenuUtil.menuManager;


public class ApplicationMainMenu {
    public static void showMenuInfo() throws UserNotFoundException, StringParseException, UserMenuValueNotFoundException, AdminNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        try {
            menuManager.menu();
        } catch (UserMenuValueNotFoundException | UserPasswordDoesntMatcherException | UserNotFoundException |
                 FlightBookingValueNotFoundException | StringParseException | AdminNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
