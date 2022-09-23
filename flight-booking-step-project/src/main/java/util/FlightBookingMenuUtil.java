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
        String origin;
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
        flightControllerManager.showAllFlight().orElseThrow().forEach(System.out::println);
    }

    public static void showFlightById() throws FlightIdNotFoundException {
        noticeManager.print("Enter id: ");
        String ID = noticeManager.readline();
        try {
            System.out.println(flightControllerManager.showFlightById(Integer.parseInt(ID)).orElseThrow());
        } catch (Exception e) {
            throw new FlightIdNotFoundException("Flight ID not found...");
        }

    }

    public static void bookingFlight() throws UserNotFoundException, StringParseException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException, AdminNotFoundException, FlightIdNotFoundException, FlightNotFoundException {
        String destination;
        String freeSeats;
        String date;
        noticeManager.print("Enter destination: ");
        destination = noticeManager.readline();
        noticeManager.print("Enter number of people (how many tickets to buy): ");
        freeSeats = noticeManager.readline();
        noticeManager.print("Enter date (ex 2022-09-12)");
        date = noticeManager.readline();
        List<Flight> flights;
        try {
            flights = flightControllerManager.showFlightByFlightInfo(destination, Integer.parseInt(freeSeats), date);
        } catch (Exception exception) {
            throw new FlightNotFoundException("Flight not found...Try again");
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
        bookingControllerManager.getAllBookingByUsername(user.getUsername()).orElseThrow().forEach(System.out::println);
    }

    public static void cancelBooking() {
        noticeManager.print("Enter id: ");
        String idForSelect = noticeManager.readline();
        bookingControllerManager.cancelBookingById(Integer.parseInt(idForSelect));
    }
}
