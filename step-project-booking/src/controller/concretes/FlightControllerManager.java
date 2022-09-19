package controller.concretes;

import controller.abstracts.FlightController;
import entity.Flight;
import entity.Ticket;
import service.concretes.FlightServiceManager;

import java.util.List;

import static util.RandomUtil.*;

public class FlightControllerManager implements FlightController {
    private final FlightServiceManager flightService = new FlightServiceManager();

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
    public List<Flight> showAllFlight() {
        return flightService.getAll();
    }

    @Override
    public Flight showFlightById(int id) {
        return flightService.getById(id);
    }
}
