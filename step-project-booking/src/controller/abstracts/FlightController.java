package controller.abstracts;


import entity.Flight;

import java.util.List;

public interface FlightController {
    void fillFlight();

    void showAllFlight();

    void showFlightById(int id);
}
