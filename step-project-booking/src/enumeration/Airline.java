package enumeration;

public enum Airline {
    AMERICAN_AIRLINES("AA", "American Airlines"),
    CONTINENTAL_AIRLINES("CO", "Continental Airlines"),
    DELTA_AIRLINES("DL", "Delta Airlines"),
    NORTHWEST_AIRLINES("NW", "Northwest Airlines");

    private final String IATACode;
    private final String airlineName;

    Airline(String IATACode, String airlineName) {
        this.IATACode = IATACode;
        this.airlineName = airlineName;
    }

    public String getIATACode() {
        return IATACode;
    }

    public String getAirlineName() {
        return airlineName;
    }

}
