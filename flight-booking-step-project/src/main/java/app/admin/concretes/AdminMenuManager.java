package app.admin.concretes;

import app.admin.abstracts.AdminMenu;
import exception.*;

import static app.admin.concretes.AdminLogIn.adminLogin;
import static util.AdminUtil.checkingAdminMenu;
import static util.MenuUtil.*;

public class AdminMenuManager implements AdminMenu {
    private static final AdminMenuManager adminMenuManager = new AdminMenuManager();

    public static void fillFlight() throws AdminNotFoundException, UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        flightBookingMenuManager.fillFlight();
    }


    @Override
    public void showPage() {
        adminMenuInterfaceManager.showAdminMenuInterface();
    }

    @Override
    public void menu() throws AdminNotFoundException, UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        showPage();
        try {
            while (true) {
                switch (checkingAdminMenu()) {
                    case "1" -> fillFlight();
                    case "2" -> menuManager.menu();
                }
            }
        } catch (Exception exception) {
            noticeManager.print("Try again...");
            adminMenuManager.menu();
        }
    }
}
