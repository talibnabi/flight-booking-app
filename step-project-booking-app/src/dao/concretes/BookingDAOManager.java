package dao.concretes;

import dao.abstracts.DAO;
import entity.Booking;
import enumeration.concretes.data.BookingDataSource;
import enumeration.concretes.file.BookingFileWorker;
import enumeration.concretes.file.FilePathAccess;

import java.util.Collection;
import java.util.Optional;


public class BookingDAOManager implements DAO<Booking> {

    @Override
    public Optional<Collection<Booking>> getAll() {
        return Optional.ofNullable(
                BookingFileWorker
                        .BOOKING_FILE_ACCESS
                        .constructor()
                        .get()
                        .readListFromFile(FilePathAccess
                                .BOOKING_DATA
                                .getFilePath()));
    }

    @Override
    public Boolean create(Booking data) {
        BookingDataSource
                .BOOKING_DATA_SOURCE
                .constructor()
                .get()
                .add(data);
        return writeToFile();
    }

    @Override
    public Boolean deleteFromFile(int id) {
        BookingDataSource
                .BOOKING_DATA_SOURCE
                .constructor()
                .get()
                .removeIf(
                        booking -> id == booking.getBookingID()
                );
        return writeToFile();
    }

    @Override
    public Boolean writeToFile() {
        return BookingFileWorker
                .BOOKING_FILE_ACCESS
                .constructor()
                .get()
                .writeListToFile(
                        FilePathAccess
                                .BOOKING_DATA
                                .getFilePath(),
                        BookingDataSource
                                .BOOKING_DATA_SOURCE
                                .constructor()
                                .get()
                );
    }
}
