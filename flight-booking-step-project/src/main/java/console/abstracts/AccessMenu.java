package console.abstracts;

import exception.*;

public interface AccessMenu {
    void showPage();
    void menu() throws UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, UserNotFoundException, FlightBookingValueNotFoundException, StringParseException, AdminNotFoundException;
}
