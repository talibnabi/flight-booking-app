package enumeration.concretes.service;

import dao.abstracts.DAO;
import dao.concretes.FlightDAOManager;
import entity.Flight;
import enumeration.abstracts.DAOWorker;

import java.util.function.Supplier;

public enum FlightDAOServiceWorker implements DAOWorker<Flight> {
    FLIGHT_DAO_SERVICE_WORKER(FlightDAOManager::new);
    private final Supplier<DAO<Flight>> flightDAOManager;

    FlightDAOServiceWorker(Supplier<DAO<Flight>> flightDAOManager) {
        this.flightDAOManager = flightDAOManager;
    }

    @Override
    public Supplier<DAO<Flight>> constructor() {
        return flightDAOManager;
    }
}
