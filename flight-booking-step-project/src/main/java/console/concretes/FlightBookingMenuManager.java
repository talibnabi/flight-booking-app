package console.concretes;

import console.abstracts.FlightBookingMenu;
import entity.Flight;
import entity.Ticket;
import exception.*;

import static util.FlightBookingMenuUtil.*;
import static util.MenuUtil.*;
import static util.RandomUtil.*;

public class FlightBookingMenuManager implements FlightBookingMenu {

    @Override
    public void fillFlight() {
        for (int i = 0; i < 100; i++) {
            Ticket ticket = new Ticket(getRandomTicketPrice());
            Flight flight = new Flight(getRandomAirline(), getRandomAirportFrom(), getRandomAirportTo(), getRandomFreeSeats(), getRandomLocalDate(), getRandomLocalTime());
            flight.setTicket(ticket);
            flightService.create(flight);
        }
    }

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
