package enumeration;

public enum Airport {
    ABIDJAN("ABJ", "Cote d'Ivoire"),
    ABILENE("ABI", "USA"),
    ACAPULCO("ACA", "Mexico"),
    ADANA("ADA", "Turkey"),
    ACCRA("ACC", "Ghana"),
    ABERDEEN("ABZ", "United Kingdom"),
    ABU_SIMBEL("ABS", "Egypt");

    private final String IATACode;
    private final String airportLocation;

    Airport(String IATACode, String airportLocation) {
        this.IATACode = IATACode;
        this.airportLocation = airportLocation;
    }

    public String getIATACode() {
        return IATACode;
    }

    public String getAirportLocation() {
        return airportLocation;
    }
}
