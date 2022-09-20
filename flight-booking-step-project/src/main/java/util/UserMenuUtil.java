package util;

import entity.User;
import exception.*;

import static util.MenuUtil.*;

public class UserMenuUtil {


    public static String username() {
        noticeManager.print("Username:");
        return noticeManager.readline();
    }

    public static String password() throws UserPasswordDoesntMatcherException {
        noticeManager.print("Password: ");
        String password = noticeManager.readline();
        if (password.length() < 8) {
            throw new UserPasswordDoesntMatcherException("Password must be minimum 8 element.Please try again....");
        }
        return password;
    }

    public static String checkingUserMenu() throws UserMenuValueNotFoundException {
        String origin = null;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2") || origin.equals("3"))) {
            throw new UserMenuValueNotFoundException("Value must be 1,2 or 3");
        }
        return origin;
    }

    public static void singInOption() throws UserPasswordDoesntMatcherException, UserNotFoundException, StringParseException, UserMenuValueNotFoundException, FlightBookingValueNotFoundException {
        user = new User(username(), password());
        if (userControllerManager.login(user.getUsername(), user.getPassword())) {
            noticeManager.print("Successfully login!");
            flightBookingMenuManager.menu();
        } else {
            throw new UserNotFoundException("User not found...");
        }
        userMenuManager.showPage();
    }

    public static void signUpOption() throws UserPasswordDoesntMatcherException {
        if (userControllerManager.register(username(), password())) {
            noticeManager.print("Registered successfully!");
        } else {
            noticeManager.print("User already exists.Please try again....");
        }
        userMenuManager.showPage();
    }
}
