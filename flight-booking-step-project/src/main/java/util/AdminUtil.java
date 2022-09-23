package util;

import exception.*;

import static util.MenuUtil.adminMenuManager;
import static util.MenuUtil.noticeManager;

public class AdminUtil {

    public static String checkingAdminMenu() throws AdminNotFoundException, UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        String origin;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2"))) {
            noticeManager.print("Value must be 1 or 2");
            adminMenuManager.menu();
        }
        return origin;
    }
}
