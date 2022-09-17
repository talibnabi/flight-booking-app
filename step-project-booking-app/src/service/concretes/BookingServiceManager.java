package service.concretes;

import entity.Booking;
import service.abstracts.BookingService;

import java.util.List;
import java.util.Optional;

public class BookingServiceManager implements BookingService {
    @Override
    public Optional<List<Booking>> getAllBookingByUser() {
        return Optional.empty();
    }

    @Override
    public Boolean booking() {
        return null;
    }

    @Override
    public Boolean cancelBooking() {
        return null;
    }
}
