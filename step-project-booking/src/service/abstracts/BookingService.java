package service.abstracts;

import entity.Booking;

import java.util.List;

public interface BookingService<T> {
    List<T> getAll();

    List<Booking> getAllBookingByUsername(String username);
    List<Booking> getAllBookingByPassengerInfo(String username,String passengerFirstName,String passengerLastName);

    T getById(int id);

    Boolean create(T object);

    Boolean delete(int id);
}
