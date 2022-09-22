package entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import static util.EntityUtil.counterID;

public final class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final int id;
    private final String username;
    private final String password;

    public Admin(String username, String password) {
        this.id = counterID("db/id/adminID.txt");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        return getId() == admin.getId() && getUsername().equals(admin.getUsername()) && getPassword().equals(admin.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword());
    }

}
