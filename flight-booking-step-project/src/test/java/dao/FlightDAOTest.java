package dao;

import dao.concretes.FlightDAOManager;
import entity.Flight;
import entity.Ticket;
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

public class FlightDAOTest {
    private static final FlightDAOManager flightDAOManager = new FlightDAOManager();
    private static final Ticket ticket = new Ticket(669);
    private static final Flight flight1 = new Flight(Airline.AMERICAN_AIRLINES, Airport.ABERDEEN, Airport.ABU_SIMBEL, 10, LocalDate.now(), LocalTime.now().plusNanos(10));


    @Test
    void getAllFlight() {
        setTicket();
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flightDAOManager.create(flight1);
        assertEquals(flights.get(0).toString(), flightDAOManager.getAll().orElseThrow().get(flight1.getId() - 2).toString());
    }

    @Test
    void getFlightById() {
        setTicket();
        flightDAOManager.create(flight1);
        assertEquals(Optional.of(flight1), flightDAOManager.getById(flight1.getId() - 2));
    }

    @Test
    void add() {
        setTicket();
        assertTrue(flightDAOManager.create(flight1));
    }

    @Test
    void remove() {
        setTicket();
        flightDAOManager.create(flight1);
        assertTrue(flightDAOManager.delete(flight1.getId()));
    }

    private static void setTicket() {
        ticket.setTicketNumber("XX1");
        flight1.setTicket(ticket);
    }
}
