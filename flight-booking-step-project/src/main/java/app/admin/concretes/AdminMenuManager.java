package app.admin.concretes;

import app.admin.abstracts.AdminMenu;
import exception.AdminNotFoundException;

import static util.AdminUtil.checkingAdminMenu;
import static util.AdminUtil.flightBookingMenuManager;
import static util.MenuUtil.adminMenuInterfaceManager;

public class AdminMenuManager implements AdminMenu {
    private static final AdminMenuManager adminMenuManager = new AdminMenuManager();

    public static void fillFlight() throws AdminNotFoundException {
        flightBookingMenuManager.fillFlight();
        adminMenuManager.menu();
    }


    @Override
    public void showPage() {
        adminMenuInterfaceManager.showAdminMenuInterface();
    }

    @Override
    public void menu() throws AdminNotFoundException {
        showPage();
        while (true) {
            switch (checkingAdminMenu()) {
                case "1" -> fillFlight();
                case "2" -> System.exit(0);
            }
        }
    }
}
