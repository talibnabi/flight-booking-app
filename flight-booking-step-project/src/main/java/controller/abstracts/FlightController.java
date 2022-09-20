package controller.abstracts;


import entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightController {

    Optional<List<Flight>> showAllFlight();

    Optional<Flight> showFlightById(int id);
    List<Flight> showFlightByFlightInfo(String destination, int seatCount, String time);
}
