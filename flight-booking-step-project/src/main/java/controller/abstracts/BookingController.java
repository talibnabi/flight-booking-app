package controller.abstracts;

import entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingController {
    Optional<List<Booking>> getAllBookingByUsername(String username);

    Optional<List<Booking>> getAllBookingByPassengerInfo(String username, String passengerFirstName, String passengerLastName);

    Boolean cancelBookingById(int id);

    Boolean createBooking(Booking booking);
}
