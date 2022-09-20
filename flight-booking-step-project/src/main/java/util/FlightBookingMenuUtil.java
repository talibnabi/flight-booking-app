package util;

import entity.Booking;
import entity.Flight;
import entity.Passenger;
import exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static util.MenuUtil.*;

public class FlightBookingMenuUtil {

    public static String checkingFlightBookingMenu() throws FlightBookingValueNotFoundException {
        String origin = null;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2") || origin.equals("3") || origin.equals("4") || origin.equals("5") || origin.equals("6"))) {
            throw new FlightBookingValueNotFoundException("Value must be 1,2,3,4,5 or 6");
        }
        return origin;
    }

    public static void showAllFlightInfo() {
        noticeManager.print(bookingTitle.bar());
        noticeManager.print(bookingTitle.title());
        noticeManager.print(bookingTitle.bar());
        flightControllerManager.showAllFlight();
    }

    public static void showFlightById() throws StringParseException {
        noticeManager.print("Enter id: ");
        String ID = noticeManager.readline();
        try {
            flightControllerManager.showFlightById(Integer.parseInt(ID));
        } catch (Exception e) {
            throw new StringParseException();
        }
    }

    public static void bookingFlight() throws UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException {
        noticeManager.print("Enter destination: ");
        String destination = noticeManager.readline();
        noticeManager.print("Enter number of people (how many tickets to buy): ");
        String freeSeats = noticeManager.readline();
        noticeManager.print("Enter date (ex 2022-09-12)");
        String date = noticeManager.readline();
        List<Flight> flights = flightControllerManager.showFlightByFlightInfo(destination, Integer.parseInt(freeSeats), date);
        if (flights.isEmpty()) {
            System.out.println("Nothing found.Please try again....");
            flightBookingMenuManager.menu();
        }
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
        Booking booking = new Booking(flights1.get(0), user, passengers, LocalDate.now());
        bookingControllerManager.createBooking(booking);
    }

    public static void getAllBookingByUserName() {
        bookingControllerManager.getAllBookingByUsername(user.getUsername());
    }

    public static void cancelBooking() {
        String idForSelect = noticeManager.readline();
        bookingControllerManager.cancelBookingById(Integer.parseInt(idForSelect));
    }
}
