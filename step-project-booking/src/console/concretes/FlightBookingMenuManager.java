package console.concretes;

import console.abstracts.FlightBookingMenu;
import controller.concretes.BookingControllerManager;
import controller.concretes.FlightControllerManager;
import entity.Flight;
import exception.*;

import java.util.List;
import java.util.stream.Collectors;

import static util.MenuUtil.*;

public class FlightBookingMenuManager implements FlightBookingMenu {
    private final FlightBookingConsoleInterfaceManager flightBookingConsoleInterfaceManager = new FlightBookingConsoleInterfaceManager();
    private final FlightControllerManager flightControllerManager = new FlightControllerManager();
    private final UserMenuManager userMenuManager = new UserMenuManager();
    private final BookingControllerManager bookingControllerManager = new BookingControllerManager();


    @Override
    public void showPage() {
        flightBookingConsoleInterfaceManager.showInterface();
    }

    @Override
    public void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, StringParseException {
        while (true) {
            showPage();
            switch (checkingFlightBookingMenu()) {
                case "1":
                    noticeManager.print(bookingTitle.bar());
                    noticeManager.print(bookingTitle.title());
                    noticeManager.print(bookingTitle.bar());
                    flightControllerManager.showAllFlight();
                    break;
                case "2":
                    noticeManager.print("Enter id: ");
                    String ID = noticeManager.readline();
                    try {
                        flightControllerManager.showFlightById(Integer.parseInt(ID));
                    } catch (Exception e) {
                        throw new StringParseException();
                    }
                    break;
                case "3":
                    noticeManager.print("Enter destination: ");
                    String destination = noticeManager.readline();
                    noticeManager.print("Enter number of people (how many tickets to buy): ");
                    String freeSeats = noticeManager.readline();
                    noticeManager.print("Enter date (ex 2022-09-12)");
                    String date = noticeManager.readline();
                    List<Flight> flights = flightControllerManager.showFlightByFlightInfo(destination, Integer.parseInt(freeSeats), date);
                    flights.forEach(System.out::println);
                    noticeManager.print("Make your choice: ");
                    String id = noticeManager.readline();
                    List<Flight> flights1 = flights.stream().filter(flightx -> flightx.getId() == Integer.parseInt(id)).toList();
                    flights1.forEach(System.out::println);
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
