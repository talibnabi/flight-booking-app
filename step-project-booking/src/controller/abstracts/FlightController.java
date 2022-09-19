package controller.abstracts;


import entity.Flight;

import java.util.List;

public interface FlightController {
    void fillFlight();

    List<Flight> showAllFlight();

    Flight showFlightById(int id);
}
