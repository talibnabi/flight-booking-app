package dao.concretes;

import dao.abstracts.DAO;
import entity.Flight;
import enumeration.concretes.data.FlightDataSource;
import enumeration.concretes.file.FilePathAccess;
import enumeration.concretes.file.FlightFileWorker;

import java.util.Collection;
import java.util.Optional;

public class FlightDAOManager implements DAO<Flight> {
    @Override
    public Optional<Collection<Flight>> getAll() {
        return Optional.ofNullable(
                FlightFileWorker
                        .FLIGHT_FILE_ACCESS
                        .constructor()
                        .get()
                        .readListFromFile(FilePathAccess
                                .FLIGHT_DATA
                                .getFilePath()));
    }

    @Override
    public Boolean create(Flight data) {
        FlightDataSource
                .FLIGHT_DATA_SOURCE
                .constructor()
                .get()
                .add(data);
        return writeToFile();
    }

    @Override
    public Boolean deleteFromFile(int id) {
        FlightDataSource
                .FLIGHT_DATA_SOURCE
                .constructor()
                .get()
                .removeIf(
                        flight -> id == flight.getId()
                );
        return writeToFile();
    }

    @Override
    public Boolean writeToFile() {
        return FlightFileWorker
                .FLIGHT_FILE_ACCESS
                .constructor()
                .get()
                .writeListToFile(
                        FilePathAccess
                                .FLIGHT_DATA
                                .getFilePath(),
                        FlightDataSource
                                .FLIGHT_DATA_SOURCE
                                .constructor()
                                .get()
                );
    }
}
