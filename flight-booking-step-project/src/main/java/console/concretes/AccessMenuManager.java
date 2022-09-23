package console.concretes;

import console.abstracts.AccessMenu;
import exception.*;

import static app.admin.concretes.AdminLogIn.adminLogin;
import static util.AccessMenuUtil.*;
import static util.MenuUtil.*;

public final class AccessMenuManager implements AccessMenu {


    @Override
    public void showPage() {
        userConsoleManager.showInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException, StringParseException, AdminNotFoundException {
        showPage();
        try {
            while (true) {
                switch (checkingUserMenu()) {
                    case "1" -> singInOption();
                    case "2" -> signUpOption();
                    case "3" -> System.exit(0);
                    case "4" -> adminLogin();
                }
            }
        } catch (AdminNotFoundException
                 | FlightBookingValueNotFoundException
                 | StringParseException | UserNotFoundException
                 | UserMenuValueNotFoundException |
                 UserPasswordDoesntMatcherException exception) {
            noticeManager.print(exception.getMessage());
            menu();
        }
    }

}
