package console.concretes;

import console.abstracts.FlightBookingMenu;
import controller.concretes.FlightControllerManager;
import exception.FlightBookingValueNotFoundException;
import exception.UserMenuValueNotFoundException;
import exception.UserNotFoundException;
import exception.UserPasswordDoesntMatcherException;

import static util.MenuUtil.*;

public class FlightBookingMenuManager implements FlightBookingMenu {
    private final FlightBookingConsoleInterfaceManager flightBookingConsoleInterfaceManager = new FlightBookingConsoleInterfaceManager();
    private final FlightControllerManager flightControllerManager = new FlightControllerManager();
    private final UserMenuManager userMenuManager=new UserMenuManager();

    @Override
    public void showPage() {
        flightBookingConsoleInterfaceManager.showInterface();
    }

    @Override
    public void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException {
        while (true) {
            noticeManager.print(bookingTitle.bar());
            noticeManager.print(bookingTitle.title());
            noticeManager.print(bookingTitle.bar());
            flightControllerManager.showAllFlight();
            showPage();
            switch (checkingFlightBookingMenu()){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    userMenuManager.menu();
                    break;
            }
            noticeManager.print("Select Flight ID: ");
            String id = noticeManager.readline();
            flightControllerManager.showFlightById(Integer.parseInt(id));
        }
    }
}
