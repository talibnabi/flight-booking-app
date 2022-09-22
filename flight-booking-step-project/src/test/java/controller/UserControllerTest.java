package controller;

import controller.concretes.UserControllerManager;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.concretes.UserServiceManager;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {
    private UserControllerManager userControllerManager;
    private User userFirst;
    private User userSecond;

    @BeforeEach
    void before() {
        UserServiceManager userServiceManager = new UserServiceManager();
        userControllerManager = new UserControllerManager();
        userFirst = userServiceManager.getById(0);
        userSecond = new User("Alisa", "alisaslan123");
    }

    @Test
    void registration() {
        assertTrue(userControllerManager.register(userSecond.getUsername(),userSecond.getPassword()));
    }
    @Test
    void falseRegistration() {
        assertFalse(userControllerManager.register(userFirst.getUsername(),userFirst.getPassword()));
    }
    @Test
    void login() {
        userControllerManager.register(userSecond.getUsername(),userSecond.getPassword());
        assertTrue(userControllerManager.login("Alisa", "alisaslan123"));
    }

    @Test
    void falseLogin() {
        assertFalse(userControllerManager.login("alisaaslan", "1234"));
    }
}
