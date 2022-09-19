import console.abstracts.UserMenu;
import console.concretes.UserMenuManager;
import exception.UserMenuValueNotFoundException;

public class ApplicationStarter {

    public static void main(String[] args)  {
        UserMenu userMenu = new UserMenuManager();
        try {
            userMenu.menu();
        }
        catch (UserMenuValueNotFoundException exception){
            System.out.println(exception.getMessage());
        }

    }


}
