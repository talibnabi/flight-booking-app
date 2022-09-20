package controller.abstracts;

public interface BookingController {
    void getAllBookingByUsername(String username);
    void getAllBookingByPassengerInfo(String username, String passengerFirstName, String passengerLastName);
    void  cancelBookingById(int id);

}
