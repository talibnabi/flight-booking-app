package controller.abstracts;

import entity.Booking;

public interface BookingController {
    void getAllBookingByUsername(String username);

    void getAllBookingByPassengerInfo(String username, String passengerFirstName, String passengerLastName);

    void cancelBookingById(int id);

    Boolean createBooking(Booking booking);
}
