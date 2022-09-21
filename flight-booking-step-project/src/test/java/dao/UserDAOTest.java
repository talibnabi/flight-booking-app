package dao;

import dao.concretes.UserDAOManager;
import entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOTest {
    private static final UserDAOManager userDAOManager = new UserDAOManager();
    private static final User user = new User("rasim", "rasim123");


    @Test
    void getAllUser() {
        userDAOManager.create(user);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        assertEquals(users.get(0).toString(), user.toString());
    }

    @Test
    void getUserById() {
        userDAOManager.create(user);
        assertEquals(Optional.of(user), userDAOManager.getById(user.getId()));
    }

    @Test
    void add() {
        assertTrue(userDAOManager.create(user));
    }

    @Test
    void remove() {
        userDAOManager.create(user);
        assertTrue(userDAOManager.delete(user.getId()));
    }
}
