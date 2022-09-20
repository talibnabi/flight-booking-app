package console.concretes;

import console.abstracts.FlightBookingMenu;
import controller.concretes.FlightControllerManager;
import exception.*;

import static util.MenuUtil.*;

public class FlightBookingMenuManager implements FlightBookingMenu {
    private final FlightBookingConsoleInterfaceManager flightBookingConsoleInterfaceManager = new FlightBookingConsoleInterfaceManager();
    private final FlightControllerManager flightControllerManager = new FlightControllerManager();
    private final UserMenuManager userMenuManager = new UserMenuManager();

    @Override
    public void showPage() {
        flightBookingConsoleInterfaceManager.showInterface();
    }

    @Override
    public void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, StringParseException {
        while (true) {
            noticeManager.print(bookingTitle.bar());
            noticeManager.print(bookingTitle.title());
            noticeManager.print(bookingTitle.bar());
            flightControllerManager.showAllFlight();
            showPage();
            switch (checkingFlightBookingMenu()) {
                case "1":
                    flightControllerManager.showAllFlight();
                    break;
                case "2":
                    String ID = noticeManager.readline();
                    try {
                        flightControllerManager.showFlightById(Integer.parseInt(ID));
                    } catch (Exception e) {
                        throw new  StringParseException();
                    }
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
        }
    }
}
