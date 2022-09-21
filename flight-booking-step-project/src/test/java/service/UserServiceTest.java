package service;

import entity.User;
import org.junit.jupiter.api.Test;
import service.concretes.UserServiceManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {
    private static final UserServiceManager userServiceManager = new UserServiceManager();
    private static final User user = new User("rasim", "rasim123");
    @Test
    void getAllUser() {
        userServiceManager.create(user);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        assertEquals(users.get(0).toString(), user.toString());
    }
    @Test
    void getUserById() {
        userServiceManager.create(user);
        assertEquals(user, userServiceManager.getById(user.getId()));
    }
    @Test
    void add() {
        assertTrue(userServiceManager.create(user));
    }

    @Test
    void remove() {
        userServiceManager.create(user);
        assertTrue(userServiceManager.delete(user.getId()));
    }

}
