package console.concretes;

import console.abstracts.FlightBookingMenu;
import exception.*;

import static util.FlightBookingMenuUtil.*;
import static util.MenuUtil.flightBookingConsoleInterfaceManager;
import static util.MenuUtil.userMenuManager;

public class FlightBookingMenuManager implements FlightBookingMenu {

    @Override
    public void showPage() {
        flightBookingConsoleInterfaceManager.showInterface();
    }

    @Override
    public void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, StringParseException {
        while (true) {
            showPage();
            switch (checkingFlightBookingMenu()) {
                case "1" -> showAllFlightInfo();
                case "2" -> showFlightById();
                case "3" -> bookingFlight();
                case "4" -> getAllBookingByUserName();
                case "5" -> cancelBooking();
                case "6" -> userMenuManager.menu();
            }
        }
    }
}
