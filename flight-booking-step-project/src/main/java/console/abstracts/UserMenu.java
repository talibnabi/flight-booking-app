package console.abstracts;

import exception.*;

public interface UserMenu {
    void showPage();
    void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException, StringParseException;
}
