package service.abstracts;

import entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Optional<List<Booking>> getAllBookingByUser();

    Boolean booking();

    Boolean cancelBooking();
}
