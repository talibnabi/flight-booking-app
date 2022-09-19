package service.abstracts;

import java.util.List;

public interface FlightService<T> {
    List<T> getAll();

    List<T> getFlightByFlightInfo(String destination, int seatCount, String time);

    T getById(int id);

    Boolean create(T object);

    Boolean delete(int id);

    Boolean updateFreeSeat(T flight, int seat);

}
