package dao.concretes;

import dao.abstracts.DAO;
import entity.Passenger;
import enumeration.concretes.data.FlightDataSource;
import enumeration.concretes.data.PassengerDataSource;
import enumeration.concretes.file.FilePathAccess;
import enumeration.concretes.file.FlightFileWorker;
import enumeration.concretes.file.PassengerFileWorker;

import java.util.Collection;
import java.util.Optional;

public class PassengerDAOManager implements DAO<Passenger> {
    @Override
    public Optional<Collection<Passenger>> getAll() {
        return Optional.empty();
    }

    @Override
    public Boolean create(Passenger data) {
        return true;
    }

    @Override
    public Boolean deleteFromFile(int id) {
        
        return writeToFile();
    }

    @Override
    public Boolean writeToFile() {
        return PassengerFileWorker
                .PASSENGER_FILE_WORKER
                .constructor()
                .get()
                .writeListToFile(
                        FilePathAccess
                                .PASSENGER_DATA
                                .getFilePath(),
                        PassengerDataSource
                                .PASSENGER_DATA_SOURCE
                                .constructor()
                                .get()
                );
    }
}
