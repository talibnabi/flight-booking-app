package app;
import exception.*;

import static util.MenuUtil.userMenuManager;

public class ApplicationMainMenu {
    public static void showMenuInfo(){
        try {
            userMenuManager.menu();
        } catch (UserMenuValueNotFoundException | UserPasswordDoesntMatcherException | UserNotFoundException |
                 FlightBookingValueNotFoundException | StringParseException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
