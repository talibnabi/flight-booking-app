package entity;

import enumeration.Airline;
import enumeration.Airport;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static util.EntityUtil.counterID;


public class Flight implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    private Ticket ticket;
    private final Airline airline;
    private final Airport startingLocation;
    private final Airport stoppingLocation;
    private int freeSeats;
    private final LocalDate flightTime;
    private final LocalTime time;


    public Flight(Airline airline, Airport startingLocation, Airport stoppingLocation, int freeSeats, LocalDate flightTime, LocalTime localTime) {
        this.id = counterID("db/id/flightID.txt");
        this.airline = airline;
        this.startingLocation = startingLocation;
        this.stoppingLocation = stoppingLocation;
        this.freeSeats = freeSeats;
        this.flightTime = flightTime;
        this.time = localTime;
    }

    public int getId() {
        return id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }


    public Airline getAirline() {
        return airline;
    }

    public Airport getStartingLocation() {
        return startingLocation;
    }

    public Airport getStoppingLocation() {
        return stoppingLocation;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public LocalDate getFlightTime() {
        return flightTime;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return getFreeSeats() == flight.getFreeSeats() && getTicket().getTicketNumber().equals(flight.getTicket().getTicketNumber()) && getFlightTime().equals(flight.getFlightTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicket().getTicketNumber(), getFreeSeats(), getFlightTime());
    }

    @Override
    public String toString() {
        return String.format(" ||  %2s  ||  %2s  ||  %2s  ||  %s --> %s  ||  %2s USD ||  %s  ||  %s %s   ", id, getTicket().getTicketNumber(), airline.getAirlineName(), startingLocation.getAirportLocation(), stoppingLocation.getAirportLocation(), ticket.getTicketPrice(),freeSeats, flightTime, time);
    }
}
