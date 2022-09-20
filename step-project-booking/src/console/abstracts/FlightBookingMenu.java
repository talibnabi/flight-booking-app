package console.abstracts;


import exception.*;

public interface FlightBookingMenu {
    void showPage();
    void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, StringParseException;
}
