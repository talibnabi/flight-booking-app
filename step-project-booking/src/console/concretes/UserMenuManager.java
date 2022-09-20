package console.concretes;

import console.abstracts.UserMenu;
import controller.concretes.FlightControllerManager;
import controller.concretes.UserControllerManager;
import exception.UserMenuValueNotFoundException;
import exception.UserNotFoundException;
import exception.UserPasswordDoesntMatcherException;

import static util.MenuUtil.*;

public class UserMenuManager implements UserMenu {
    private final UserConsoleInterfaceManager userConsoleManager = new UserConsoleInterfaceManager();
    private final UserControllerManager userControllerManager = new UserControllerManager();
    private final FlightBookingMenuManager flightBookingMenuManager = new FlightBookingMenuManager();

    @Override
    public void showPage() {
        userConsoleManager.showInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException {
        showPage();
        while (true) {
            switch (checking()) {
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
