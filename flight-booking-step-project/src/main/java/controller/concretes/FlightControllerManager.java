package controller.concretes;

import controller.abstracts.FlightController;
import entity.Flight;
import entity.Ticket;
import service.concretes.FlightServiceManager;

import java.util.List;


public class FlightControllerManager implements FlightController {
    private final FlightServiceManager flightService = new FlightServiceManager();

    @Override
    public void showAllFlight() {
        flightService.getAll().forEach(System.out::println);
    }

    @Override
    public void showFlightById(int id) {
        System.out.println(flightService.getById(id));
    }

    @Override
    public List<Flight> showFlightByFlightInfo(String destination, int seatCount, String time) {
        return flightService.getFlightByFlightInfo(destination, seatCount, time);
    }
}
