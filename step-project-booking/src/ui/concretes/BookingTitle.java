package ui.concretes;

import ui.abstracts.Title;


public class BookingTitle implements Title {

    @Override
    public String title() {
        return "||  ID  ||  TICKET NUM  ||  AIRLINE NAME  ||  AIRPORT STARTING  ||  AIRPORT STOPPING  ||  TICKET PRICE  ||  FREE SEATS  ||  DATE  ||";
    }

    @Override
    public String bar() {
        return "=============================================================================================================================================";
    }
}
