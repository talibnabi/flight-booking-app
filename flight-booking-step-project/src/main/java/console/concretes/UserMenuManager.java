package console.concretes;

import console.abstracts.UserMenu;
import exception.*;

import static util.MenuUtil.userConsoleManager;
import static util.UserMenuUtil.*;

public class UserMenuManager implements UserMenu {


    @Override
    public void showPage() {
        userConsoleManager.showInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException, StringParseException {
        showPage();
        while (true) {
            switch (checkingUserMenu()) {
                case "1" -> singInOption();
                case "2" -> signUpOption();
                case "3" -> System.exit(0);
            }
        }
    }

}
