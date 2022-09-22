package service;

import dao.concretes.FlightDAOManager;
import entity.Flight;
import entity.Ticket;
import enumeration.Airline;
import enumeration.Airport;
import org.junit.jupiter.api.Test;
import service.concretes.FlightServiceManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightServiceTest {
    private static final FlightServiceManager flightServiceManager = new FlightServiceManager();
    private static final Ticket ticket = new Ticket(669);
    private static final Flight flight1 = new Flight(Airline.AMERICAN_AIRLINES, Airport.ABERDEEN, Airport.ABU_SIMBEL, 10, LocalDate.now(), LocalTime.now().plusNanos(10));
    @Test
    void getAllFlight() {
        setTicket();
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flightServiceManager.create(flight1);
        assertEquals(flights.get(0).toString(), flight1.toString());
    }

    @Test
    void getFlightById() {
        setTicket();
        flightServiceManager.create(flight1);
        assertEquals(Optional.of(flight1).orElseThrow(), flightServiceManager.getById(flight1.getId()));
    }

    @Test
    void add() {
        setTicket();
        assertTrue(flightServiceManager.create(flight1));
    }

    @Test
    void remove() {
        setTicket();
        flightServiceManager.create(flight1);
        assertTrue(flightServiceManager.delete(flight1.getId()));
    }

    private static void setTicket() {
        ticket.setTicketNumber("XX1");
        flight1.setTicket(ticket);
    }
}
