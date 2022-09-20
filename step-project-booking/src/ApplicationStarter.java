import console.abstracts.UserMenu;
import console.concretes.UserMenuManager;
import exception.*;

public class ApplicationStarter {

    public static void main(String[] args) {
        UserMenu userMenu = new UserMenuManager();
        try {
            userMenu.menu();
        } catch (UserMenuValueNotFoundException | UserPasswordDoesntMatcherException | UserNotFoundException |
                 FlightBookingValueNotFoundException | StringParseException exception) {
            System.out.println(exception.getMessage());
        }
    }


}
