package dao.abstracts;

import entity.Flight;

public interface FlightDAO<F> extends DAO<Flight> {
    Boolean update(Flight flight);
}
