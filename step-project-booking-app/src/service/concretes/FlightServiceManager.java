package service.concretes;

import entity.Flight;
import service.abstracts.FlightService;

import java.util.List;
import java.util.Optional;

public class FlightServiceManager implements FlightService {
    @Override
    public Optional<List<Flight>> getAllFlights() {
        return Optional.empty();
    }

    @Override
    public Optional<List<Flight>> booking() {
        return Optional.empty();
    }

    @Override
    public Flight getFlight() {
        return null;
    }
}