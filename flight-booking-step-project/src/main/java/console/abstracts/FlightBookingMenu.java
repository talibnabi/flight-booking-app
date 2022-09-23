package console.abstracts;


import exception.*;

public interface FlightBookingMenu {
    void fillFlight() throws UserNotFoundException, StringParseException, UserMenuValueNotFoundException, AdminNotFoundException, UserPasswordDoesntMatcherException, FlightBookingValueNotFoundException;
    void showPage();
    void menu() throws FlightBookingValueNotFoundException, UserNotFoundException, UserMenuValueNotFoundException, UserPasswordDoesntMatcherException, StringParseException, AdminNotFoundException;
}
