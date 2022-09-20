package util;

import console.concretes.*;
import controller.concretes.BookingControllerManager;
import controller.concretes.FlightControllerManager;
import controller.concretes.UserControllerManager;
import entity.User;
import service.concretes.FlightServiceManager;
import ui.concretes.BookingTitle;
import ui.concretes.BookingUIPage;
import ui.concretes.UserUIPage;

import java.util.Scanner;


public class MenuUtil {
    public static final FlightServiceManager flightService = new FlightServiceManager();
    public static final UserMenuManager userMenuManager = new UserMenuManager();
    public static final BookingUIPage bookingUIPage = new BookingUIPage();
    public static final Scanner scanner = new Scanner(System.in);
    public static final NoticeManager noticeManager = new NoticeManager();
    public static final BookingControllerManager bookingControllerManager = new BookingControllerManager();
    public static final BookingTitle bookingTitle = new BookingTitle();
    public static final UserUIPage userUIPage = new UserUIPage();
    public static final FlightBookingMenuManager flightBookingMenuManager = new FlightBookingMenuManager();
    public static final FlightBookingConsoleInterfaceManager flightBookingConsoleInterfaceManager = new FlightBookingConsoleInterfaceManager();
    public static final FlightControllerManager flightControllerManager = new FlightControllerManager();

    public static final UserConsoleInterfaceManager userConsoleManager = new UserConsoleInterfaceManager();
    public static final UserControllerManager userControllerManager = new UserControllerManager();
    public static User user;
}
