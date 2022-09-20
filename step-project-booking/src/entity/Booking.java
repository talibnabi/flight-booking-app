package entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static util.EntityUtil.counterID;


public class Booking implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    private final Flight flight;
    private final User user;
    private List<Passenger> passengers;
    private final LocalDate bookingTime;

    public Booking(Flight flight, User user, List<Passenger> passengers, LocalDate bookingTime) {
        this.id = counterID("db/id/bookingID.txt");
        this.flight = flight;
        this.user = user;
        if (flight.getFreeSeats() > passengers.size()) {
            this.passengers = passengers;
            flight.setFreeSeats(flight.getFreeSeats() - passengers.size());
        } else {
            flight.setFreeSeats(0);
        }
        this.bookingTime = bookingTime;
    }

    public int getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public LocalDate getBookingTime() {
        return bookingTime;
    }

    public void setPassengers(List<Passenger> passengers) {
        if (flight.getFreeSeats() > passengers.size()) {
            this.passengers = passengers;
            flight.setFreeSeats(flight.getFreeSeats() - passengers.size());
        } else {
            flight.setFreeSeats(0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return getId() == booking.getId() && getFlight().equals(booking.getFlight()) && getBookingTime().equals(booking.getBookingTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFlight(), getBookingTime());
    }

    @Override
    public String toString() {
        return String.format("| %s | %s | %s | %s | %s |", id, flight, user, passengers, bookingTime);
    }
}
