package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static util.EntityUtil.counterID;


public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.id = counterID("db/id/userID.txt");
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("| %s | %s | %s |", id, username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && getUsername().equals(user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername());
    }

}
