package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static util.EntityUtil.counterID;


public class Passenger implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    private final String firstName;
    private final String lastName;

    public Passenger(String firstName, String lastName) {
        this.id = counterID("./db/id/passengerID.txt");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passenger)) return false;
        return getFirstName().equals(passenger.getFirstName()) && getLastName().equals(passenger.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
