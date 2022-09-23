package app.admin.concretes;

import entity.Admin;
import exception.*;

import static util.MenuUtil.*;
import static util.MenuUtil.menuManager;

public class AdminLogIn {
    public static void adminLogin() throws AdminNotFoundException, UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        noticeManager.print("Admin Username: ");
        String adminUsername = noticeManager.readline();
        noticeManager.print("Admin Password: ");
        String adminPassword=noticeManager.readline();
        admin = new Admin(adminUsername, adminPassword);
        if (adminControllerManager.login(admin.getUsername(), admin.getPassword())) {
            noticeManager.print("Successfully login!");
            adminMenuManager.menu();
        } else {
            throw new AdminNotFoundException("Admin not found.Try again....");
        }
        menuManager.showPage();
    }
}
