package controller.concretes;

import controller.abstracts.BookingController;
import entity.Booking;
import service.concretes.BookingServiceManager;

public class BookingControllerManager implements BookingController {
    private final BookingServiceManager bookingServiceManager = new BookingServiceManager();

    @Override
    public void getAllBookingByUsername(String username) {
        bookingServiceManager.getAllBookingByUsername(username).forEach(System.out::println);
    }

    @Override
    public void getAllBookingByPassengerInfo(String username, String passengerFirstName, String passengerLastName) {
        bookingServiceManager.getAllBookingByPassengerInfo(username, passengerFirstName, passengerLastName).forEach(System.out::println);
    }

    @Override
    public void cancelBookingById(int id) {
        bookingServiceManager.delete(id);
    }

    @Override
    public Boolean createBooking(Booking booking) {
        return bookingServiceManager.create(booking);
    }
}
