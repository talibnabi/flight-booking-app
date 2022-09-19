package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static util.EntityUtil.counterID;

public class Ticket implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    private String ticketNumber;
    private int ticketPrice;

    public Ticket(int ticketPrice) {
        this.id = counterID("./db/id/ticketID.txt");
        this.ticketNumber = "XX" + counterID("./db/id/ticketID.txt");
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }



    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() && getTicketPrice() == ticket.getTicketPrice() && getTicketNumber().equals(ticket.getTicketNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTicketNumber(), getTicketPrice());
    }

    @Override
    public String toString() {
        return String.format("| %s | %s | %s |", id, ticketNumber, ticketPrice);
    }
}
