package service;

import dao.concretes.BookingDAOManager;
import dao.concretes.FlightDAOManager;
import dao.concretes.UserDAOManager;
import entity.*;
import enumeration.Airline;
import enumeration.Airport;
import org.junit.jupiter.api.Test;
import service.concretes.BookingServiceManager;
import service.concretes.FlightServiceManager;
import service.concretes.UserServiceManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingServiceTest {
    private static final BookingServiceManager bookingServiceManager = new BookingServiceManager();
    private static final FlightServiceManager flightServiceManager = new FlightServiceManager();
    private static final Ticket ticket = new Ticket(669);
    private static final Flight flight1 = new Flight(Airline.AMERICAN_AIRLINES, Airport.ABERDEEN, Airport.ABU_SIMBEL, 10, LocalDate.now(), LocalTime.now().plusNanos(10));
    private static final Passenger passengerFirst = new Passenger("Talib", "Nabi");
    private static final Passenger passengerSecond = new Passenger("Talib", "Nabi");
    private static final UserServiceManager userServiceManager = new UserServiceManager();
    private static final User user = new User("rasim", "rasim123");

    @Test
    public void getAllBooking() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightServiceManager.create(flight1);
        userServiceManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        assertEquals(bookings.get(0).toString(), booking.toString());
    }

    @Test
    public void getBookingById() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightServiceManager.create(flight1);
        userServiceManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        bookingServiceManager.create(booking);
        assertEquals(Optional.of(booking).orElseThrow(), bookingServiceManager.getById(booking.getId()));
    }

    @Test
    public void add() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightServiceManager.create(flight1);
        userServiceManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        assertTrue(bookingServiceManager.create(booking));
    }
    @Test
    public void remove(){
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerFirst);
        passengers.add(passengerSecond);
        setTicket();
        flightServiceManager.create(flight1);
        userServiceManager.create(user);
        Booking booking=new Booking(flight1, user, passengers, LocalDate.now());
        assertTrue(bookingServiceManager.delete(booking.getId()));
    }
    private static void setTicket() {
        ticket.setTicketNumber("XX1");
        flight1.setTicket(ticket);
    }
}
