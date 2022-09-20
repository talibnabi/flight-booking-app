package dao.concretes;

import dao.abstracts.FlightDAO;
import file.abstracts.FilePath;
import entity.Flight;
import file.abstracts.FileWorking;
import file.concretes.WorkingWithFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDAOManager implements FlightDAO<Flight>, FilePath<Flight> {
    private final FileWorking<Flight> fileWorking = new WorkingWithFile<>();

    @Override
    public Optional<List<Flight>> getAll() {
        return Optional.ofNullable(fileWorking.readListFromFile(getFilePath()));
    }

    @Override
    public Optional<Flight> getById(int id) {
        return Optional.ofNullable(getAll().orElseThrow().stream().filter(flight -> flight.getId() == id).toList().get(0));
    }

    @Override
    public Boolean create(Flight object) {
        List<Flight> flights = new ArrayList<>(getAll().orElseThrow());
        flights.add(object);
        return fileWorking.writeListToFile(getFilePath(), flights);
    }

    @Override
    public Boolean delete(int id) {
        return fileWorking.writeListToFile(getFilePath(), getAll().orElseThrow().stream().filter(flight -> flight.getId() != id).toList());
    }

    @Override
    public String getFilePath() {
        return "db/datasource/flight.bin";
    }

    @Override
    public Boolean update(Flight flight) {
        Boolean deletedFlight = delete(flight.getId());
        if (deletedFlight) {
            return create(flight);
        }
        return false;
    }
}
