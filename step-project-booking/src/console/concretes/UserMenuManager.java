package console.concretes;

import console.abstracts.UserMenu;
import controller.concretes.UserControllerManager;
import exception.UserMenuValueNotFoundException;

import static util.MenuUtil.*;

public class UserMenuManager implements UserMenu {
    private final UserConsoleManager userConsoleManager = new UserConsoleManager();
    private final UserControllerManager userControllerManager = new UserControllerManager();

    @Override
    public void showPage() {
        userConsoleManager.showUserInterface();
    }

    @Override
    public void menu() throws UserMenuValueNotFoundException {
        showPage();
        while (true) {
            switch (checking()) {
                case "1":
                    if (userControllerManager.login(username(), password())) {
                        System.out.println("Successfully login!");
                    } else {
                        noticeManager.print("User doesn't exists.Please try again....");
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
