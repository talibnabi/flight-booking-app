package dao.concretes;

import dao.abstracts.BookingDAO;
import dao.abstracts.DAO;
import file.abstracts.FilePath;
import entity.Booking;
import file.abstracts.FileWorking;
import file.concretes.WorkingWithFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDAOManager implements BookingDAO<Booking>, FilePath<Booking> {
    private final FileWorking<Booking> fileWorking = new WorkingWithFile<>();

    @Override
    public Optional<List<Booking>> getAll() {
        return Optional.ofNullable(fileWorking.readListFromFile(getFilePath()));
    }

    @Override
    public Optional<Booking> getById(int id) {
        return Optional.ofNullable(getAll().orElseThrow().stream().filter(booking -> booking.getId() == id).toList().get(0));
    }

    @Override
    public Boolean create(Booking object) {
        return new ArrayList<>(getAll().orElseThrow()).add(object);
    }

    @Override
    public Boolean delete(int id) {
        return fileWorking.writeListToFile(getFilePath(), getAll().orElseThrow().stream().filter(booking -> booking.getId() != id).toList());
    }

    @Override
    public String getFilePath() {
        return "./db/datasource/booking.bin";
    }

}
