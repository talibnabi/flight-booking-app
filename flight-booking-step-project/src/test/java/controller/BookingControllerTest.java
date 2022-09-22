package controller;

import controller.concretes.BookingControllerManager;
import dao.concretes.FlightDAOManager;
import dao.concretes.UserDAOManager;
import entity.Booking;
import entity.Flight;
import entity.Passenger;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingControllerTest {
    private BookingControllerManager bookingControllerManager;
    private Booking booking;
    private User user;

    @BeforeEach
    void before() {
        UserDAOManager userDAOManager = new UserDAOManager();
        FlightDAOManager flightDAOManager = new FlightDAOManager();
        bookingControllerManager = new BookingControllerManager();
        user = userDAOManager.getAll().orElseThrow().get(0);
        Flight flight = flightDAOManager.getAll().orElseThrow().get(0);
        List<Passenger> passengers =
                new ArrayList<>(List.of(new Passenger("Nazim", "Hikmat")));
        booking = new Booking(flight, user, passengers, LocalDate.now());
    }

}
