import console.abstracts.UserMenu;
import console.concretes.UserMenuManager;
import exception.UserMenuValueNotFoundException;
import exception.UserNotFoundException;
import exception.UserPasswordDoesntMatcherException;

public class ApplicationStarter {

    public static void main(String[] args) {
        UserMenu userMenu = new UserMenuManager();
        try {
            userMenu.menu();
        } catch (UserMenuValueNotFoundException | UserPasswordDoesntMatcherException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

    }


}
