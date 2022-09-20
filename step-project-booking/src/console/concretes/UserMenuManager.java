package console.concretes;

import console.abstracts.UserMenu;
import controller.concretes.FlightControllerManager;
import controller.concretes.UserControllerManager;
import exception.*;

import static util.MenuUtil.*;

public class UserMenuManager implements UserMenu {
    private final UserConsoleInterfaceManager userConsoleManager = new UserConsoleInterfaceManager();
    private final UserControllerManager userControllerManager = new UserControllerManager();
    @Override
    public void showPage() {
        userConsoleManager.showInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException, StringParseException {
        showPage();
        while (true) {
            switch (checkingUserMenu()) {
                case "1":
                    if (userControllerManager.login(username(), password())) {
                        noticeManager.print("Successfully login!");
                        flightBookingMenuManager.menu();
                    } else {
                        throw new UserNotFoundException("User not found...");
                    }
                    showPage();
                    break;
                case "2":
                    if (userControllerManager.register(username(), password())) {
                        noticeManager.print("Registered successfully!");
                    } else {
                        noticeManager.print("User already exists.Please try again....");
                    }
                    showPage();
                    break;
                case "3":
                    System.exit(0);

            }
        }
    }

}
