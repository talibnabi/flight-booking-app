package console.abstracts;


import exception.FlightBookingValueNotFoundException;
import exception.UserMenuValueNotFoundException;
import exception.UserNotFoundException;
import exception.UserPasswordDoesntMatcherException;

public interface FlightBookingMenu {
    void showPage();
    void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException;
}
