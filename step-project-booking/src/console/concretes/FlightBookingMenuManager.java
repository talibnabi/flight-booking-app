package console.concretes;

import console.abstracts.FlightBookingMenu;
import controller.concretes.FlightControllerManager;

import static util.MenuUtil.*;

public class FlightBookingMenuManager implements FlightBookingMenu {
    private final FlightBookingConsoleInterfaceManager flightBookingConsoleInterfaceManager = new FlightBookingConsoleInterfaceManager();
    private final FlightControllerManager flightControllerManager = new FlightControllerManager();

    @Override
    public void showPage() {
        flightBookingConsoleInterfaceManager.showInterface();
    }

    @Override
    public void menu() {
        while (true) {
            noticeManager.print(bookingTitle.bar());
            noticeManager.print(bookingTitle.title());
            noticeManager.print(bookingTitle.bar());
            flightControllerManager.showAllFlight();
            
            noticeManager.print("Select Flight ID: ");
            String id = noticeManager.readline();
            flightControllerManager.showFlightById(Integer.parseInt(id));
        }
    }
}
