package util;

import app.admin.concretes.AdminMenuInterfaceManager;
import app.admin.concretes.AdminMenuManager;
import console.concretes.*;
import controller.concretes.AdminControllerManager;
import controller.concretes.BookingControllerManager;
import controller.concretes.FlightControllerManager;
import controller.concretes.UserControllerManager;
import entity.Admin;
import entity.User;
import service.concretes.AdminServiceManager;
import service.concretes.FlightServiceManager;
import ui.concretes.AdminUIPage;
import ui.concretes.BookingTitle;
import ui.concretes.BookingUIPage;
import ui.concretes.AccessUIPage;

import java.util.Scanner;


public class MenuUtil {
    public static final FlightBookingMenuManager flightBookingMenuManager = new FlightBookingMenuManager();
    public static final AdminMenuManager adminMenuManager = new AdminMenuManager();

    public static final AdminMenuInterfaceManager adminMenuInterfaceManager=new AdminMenuInterfaceManager();
    public static final AdminServiceManager adminServiceManager=new AdminServiceManager();
    public static final AdminControllerManager adminControllerManager=new AdminControllerManager();
    public static final FlightServiceManager flightService = new FlightServiceManager();
    public static final AccessMenuManager menuManager = new AccessMenuManager();
    public static final BookingUIPage bookingUIPage = new BookingUIPage();
    public static final Scanner scanner = new Scanner(System.in);
    public static final NoticeManager noticeManager = new NoticeManager();
    public static final BookingControllerManager bookingControllerManager = new BookingControllerManager();
    public static final BookingTitle bookingTitle = new BookingTitle();
    public static final AccessUIPage ACCESS_UI_PAGE = new AccessUIPage();
    public static final AdminUIPage ADMIN_UI_PAGE=new AdminUIPage();
    public static final FlightBookingConsoleInterfaceManager flightBookingConsoleInterfaceManager = new FlightBookingConsoleInterfaceManager();
    public static final FlightControllerManager flightControllerManager = new FlightControllerManager();

    public static final UserConsoleInterfaceManager userConsoleManager = new UserConsoleInterfaceManager();
    public static final UserControllerManager userControllerManager = new UserControllerManager();
    public static User user;
    public static Admin admin;
}
