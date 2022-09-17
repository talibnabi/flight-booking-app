package enumeration.concretes.service;

import dao.abstracts.DAO;
import dao.concretes.BookingDAOManager;
import entity.Booking;
import enumeration.abstracts.DAOWorker;

import java.util.function.Supplier;

public enum BookingDAOServiceWorker implements DAOWorker<Booking> {

    BOOKING_DAO_SERVICE_WORKER(BookingDAOManager::new);
    private final Supplier<DAO<Booking>> bookingDAOManager;

    BookingDAOServiceWorker(Supplier<DAO<Booking>> bookingDAOManager) {
        this.bookingDAOManager = bookingDAOManager;
    }

    @Override
    public Supplier<DAO<Booking>> constructor() {
        return bookingDAOManager;
    }
}
