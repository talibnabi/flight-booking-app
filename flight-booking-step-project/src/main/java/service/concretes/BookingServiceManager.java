package service.concretes;

import dao.concretes.BookingDAOManager;
import entity.Booking;
import service.abstracts.BookingService;

import java.util.List;
import java.util.stream.Collectors;

public final class BookingServiceManager implements BookingService<Booking> {
    private final BookingDAOManager bookingDAOManager = new BookingDAOManager();

    @Override
    public List<Booking> getAll() {
        return bookingDAOManager.getAll().orElseThrow();
    }

    @Override
    public List<Booking> getAllBookingByUsername(String username) {
        return getAll().stream().filter(booking -> booking.getUser().getUsername().equals(username)).collect(Collectors.toList());
    }

    @Override
    public List<Booking> getAllBookingByPassengerInfo(String username, String passengerFirstName, String passengerLastName) {
        return getAllBookingByUsername(username).stream().filter(booking -> booking.getPassengers().stream().anyMatch(passenger -> passenger.getFirstName().equals(passengerFirstName) && passenger.getLastName().equals(passengerLastName))).collect(Collectors.toList());
    }

    @Override
    public Booking getById(int id) {
        return bookingDAOManager.getById(id).orElseThrow();
    }

    @Override
    public Boolean create(Booking object) {
        return bookingDAOManager.create(object);
    }

    @Override
    public Boolean delete(int id) {
        return bookingDAOManager.delete(id);
    }
}
