package console.concretes;

import console.abstracts.FlightBookingMenu;
import controller.concretes.BookingControllerManager;
import controller.concretes.FlightControllerManager;
import entity.Booking;
import entity.Flight;
import entity.Passenger;
import exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static console.concretes.UserMenuManager.user;
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
                    List<Passenger> passengers = new ArrayList<>();
                    for (int i = 0; i < Integer.parseInt(freeSeats); i++) {
                        noticeManager.print("Enter passenger " + (i + 1) + " firstname: ");
                        String firstName = noticeManager.readline();
                        noticeManager.print("Enter passenger " + (i + 1) + " lastname: ");
                        String lastName = noticeManager.readline();
                        Passenger passenger = new Passenger(firstName, lastName);
                        passengers.add(passenger);
                    }
                    Booking booking = new Booking(flights.get(0), user, passengers, LocalDate.now());
                    bookingControllerManager.createBooking(booking);
                    break;
                case "4":
                    bookingControllerManager.getAllBookingByUsername(user.getUsername());
                    break;
                case "5":
                    String idForSelect = noticeManager.readline();
                    bookingControllerManager.cancelBookingById(Integer.parseInt(idForSelect));
                    break;
                case "6":
                    userMenuManager.menu();
                    break;
            }
        }
    }
}
