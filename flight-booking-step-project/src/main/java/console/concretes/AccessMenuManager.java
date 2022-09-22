package console.concretes;

import console.abstracts.AccessMenu;
import exception.*;

import static app.admin.concretes.AdminLogIn.adminLogin;
import static util.MenuUtil.userConsoleManager;
import static util.AccessMenuUtil.*;

public final class AccessMenuManager implements AccessMenu {


    @Override
    public void showPage() {
        userConsoleManager.showInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException, StringParseException, AdminNotFoundException {
        showPage();
        while (true) {
            switch (checkingUserMenu()) {
                case "1" -> singInOption();
                case "2" -> signUpOption();
                case "3" -> System.exit(0);
                case "4" -> adminLogin();
            }
        }
    }

}
