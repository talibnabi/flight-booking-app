package util;

import console.concretes.NoticeManager;
import controller.concretes.FlightControllerManager;
import exception.UserMenuValueNotFoundException;
import exception.UserPasswordDoesntMatcherException;
import ui.concretes.BookingTitle;

public class MenuUtil {
    public static final NoticeManager noticeManager = new NoticeManager();
    public static final BookingTitle bookingTitle = new BookingTitle();
    public static final FlightControllerManager flightControllerManager = new FlightControllerManager();


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

    public static String checking() throws UserMenuValueNotFoundException {
        String origin = null;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2") || origin.equals("3"))) {
            throw new UserMenuValueNotFoundException("Value must be 1,2 or 3");
        }
        return origin;
    }
}
