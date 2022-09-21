package dao;

import dao.concretes.UserDAOManager;
import entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDAOTest {
    @Test
    void getAllUser() {
        UserDAOManager userDAOManager=new UserDAOManager();
        User user = new User("rasim", "rasim123");
        userDAOManager.create(user);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        assertEquals(users.get(0).toString(), user.toString());
    }
    
}
