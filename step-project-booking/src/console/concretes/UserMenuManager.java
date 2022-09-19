package console.concretes;

import console.abstracts.UserMenu;
import controller.concretes.FlightControllerManager;
import controller.concretes.UserControllerManager;
import exception.UserMenuValueNotFoundException;
import exception.UserNotFoundException;
import exception.UserPasswordDoesntMatcherException;
import ui.concretes.BookingTitle;

import static util.MenuUtil.*;

public class UserMenuManager implements UserMenu {
    private final UserConsoleManager userConsoleManager = new UserConsoleManager();
    private final UserControllerManager userControllerManager = new UserControllerManager();
    private final FlightControllerManager flightControllerManager = new FlightControllerManager();
    private final BookingTitle bookingTitle = new BookingTitle();

    @Override
    public void showPage() {
        userConsoleManager.showUserInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException {
        showPage();
        while (true) {
            switch (checking()) {
                case "1":
                    if (userControllerManager.login(username(), password())) {
                        noticeManager.print("Successfully login!");
                        noticeManager.print(bookingTitle.bar());
                        noticeManager.print(bookingTitle.title());
                        noticeManager.print(bookingTitle.bar());
                        flightControllerManager.showAllFlight();

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
