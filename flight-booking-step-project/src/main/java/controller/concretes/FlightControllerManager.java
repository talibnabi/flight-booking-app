package controller.concretes;

import controller.abstracts.FlightController;
import entity.Flight;
import service.concretes.FlightServiceManager;

import java.util.List;
import java.util.Optional;


public class FlightControllerManager implements FlightController {
    private  FlightServiceManager flightService = new FlightServiceManager();

    @Override
    public Optional<List<Flight>> showAllFlight() {
        return Optional.ofNullable(flightService.getAll());
    }

    @Override
    public Optional<Flight> showFlightById(int id) {
        return Optional.ofNullable(flightService.getById(id));
    }

    @Override
    public List<Flight> showFlightByFlightInfo(String destination, int seatCount, String time) {
        return flightService.getFlightByFlightInfo(destination, seatCount, time);
    }

    public void setFlightService(FlightServiceManager flightService) {
        this.flightService = flightService;
    }
}
