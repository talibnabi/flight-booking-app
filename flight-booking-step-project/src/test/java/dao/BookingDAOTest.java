package dao;

import dao.concretes.BookingDAOManager;
import dao.concretes.FlightDAOManager;
import dao.concretes.UserDAOManager;
import entity.*;
import enumeration.Airline;
import enumeration.Airport;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingDAOTest {
    private static final BookingDAOManager bookingDAOManager = new BookingDAOManager();
    private static final FlightDAOManager flightDAOManager = new FlightDAOManager();
    private static final Ticket ticket = new Ticket(669);
    private static final Flight flight1 = new Flight(Airline.AMERICAN_AIRLINES, Airport.ABERDEEN, Airport.ABU_SIMBEL, 10, LocalDate.now(), LocalTime.now().plusNanos(10));
    private static final Passenger passengerFirst = new Passenger("Talib", "Nabi");
    private static final Passenger passengerSecond = new Passenger("Talib", "Nabi");
    private static final UserDAOManager userDAOManager = new UserDAOManager();
    private static final User user = new User("rasim", "rasim123");


    @Test
    public void getAllBooking() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightDAOManager.create(flight1);
        userDAOManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        assertEquals(bookings.get(0).toString(), bookingDAOManager.getAll().orElseThrow().get(booking.getId()));
    }

    @Test
    public void getBookingById() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightDAOManager.create(flight1);
        userDAOManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        assertEquals(Optional.of(booking), bookingDAOManager.getById(booking.getId()));
    }

    @Test
    public void add() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightDAOManager.create(flight1);
        userDAOManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        assertTrue(bookingDAOManager.create(booking));
    }
    @Test
    public void remove(){
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightDAOManager.create(flight1);
        userDAOManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        assertTrue(bookingDAOManager.delete(booking.getId()));
    }
    private static void setTicket() {
        ticket.setTicketNumber("XX1");
        flight1.setTicket(ticket);
    }


}
