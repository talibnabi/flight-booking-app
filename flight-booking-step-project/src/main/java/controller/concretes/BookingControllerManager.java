package controller.concretes;

import controller.abstracts.BookingController;
import entity.Booking;
import service.concretes.BookingServiceManager;

import java.util.List;
import java.util.Optional;

public class BookingControllerManager implements BookingController {
    private final BookingServiceManager bookingServiceManager = new BookingServiceManager();

    @Override
    public Optional<List<Booking>> getAllBookingByUsername(String username) {
        return Optional.ofNullable(bookingServiceManager.getAllBookingByUsername(username));
    }

    @Override
    public Optional<List<Booking>> getAllBookingByPassengerInfo(String username, String passengerFirstName, String passengerLastName) {
        return Optional.ofNullable(bookingServiceManager.getAllBookingByPassengerInfo(username, passengerFirstName, passengerLastName));
    }

    @Override
    public Boolean cancelBookingById(int id) {
        return bookingServiceManager.delete(id);
    }

    @Override
    public Boolean createBooking(Booking booking) {
        return bookingServiceManager.create(booking);
    }
}
