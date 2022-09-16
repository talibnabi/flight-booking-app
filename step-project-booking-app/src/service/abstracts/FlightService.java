package service.abstracts;

import entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Optional<List<Flight>> getAllFlights();

    Optional<List<Flight>> booking();

    Flight getFlight();
}
