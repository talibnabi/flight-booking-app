package service.concretes;


import dao.concretes.FlightDAOManager;
import entity.Flight;
import service.abstracts.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceManager implements FlightService<Flight> {
    private final FlightDAOManager flightDAO = new FlightDAOManager();

    @Override
    public List<Flight> getAll() {
        return flightDAO.getAll().orElseThrow();
    }

    @Override
    public List<Flight> getFlightByFlightInfo(String destination, int seatCount, String time) {
        return getAll().stream().filter(flight -> flight.getStoppingLocation().getAirportLocation().equals(destination) && flight.getFreeSeats() == seatCount && flight.getFlightTime().toString().equals(time)).sorted().collect(Collectors.toList());
    }

    @Override
    public Flight getById(int id) {
        return flightDAO.getById(id).orElseThrow();
    }

    @Override
    public Boolean create(Flight object) {
        return flightDAO.create(object);
    }

    @Override
    public Boolean delete(int id) {
        return flightDAO.delete(id);
    }

    @Override
    public Boolean updateFreeSeat(Flight flight, int seat) {
        flight.setFreeSeats(flight.getFreeSeats() - seat);
        return flightDAO.update(flight);
    }
}
