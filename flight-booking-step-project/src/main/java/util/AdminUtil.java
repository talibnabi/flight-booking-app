package util;

import app.admin.concretes.AdminMenuManager;
import console.concretes.FlightBookingMenuManager;
import exception.AdminNotFoundException;

import static util.MenuUtil.noticeManager;

public class AdminUtil {
    public static final FlightBookingMenuManager flightBookingMenuManager = new FlightBookingMenuManager();
    public static final AdminMenuManager adminMenuManager = new AdminMenuManager();

    public static String checkingAdminMenu() throws AdminNotFoundException {
        String origin = null;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2"))) {
            throw new AdminNotFoundException("Value must be 1 or 2");
        }
        return origin;
    }
}
