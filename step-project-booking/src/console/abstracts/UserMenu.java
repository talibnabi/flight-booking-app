package console.abstracts;

import exception.FlightBookingValueNotFoundException;
import exception.UserMenuValueNotFoundException;
import exception.UserNotFoundException;
import exception.UserPasswordDoesntMatcherException;

public interface UserMenu {
    void showPage();
    void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException;
}
