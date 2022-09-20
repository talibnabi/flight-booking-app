package controller.concretes;

import controller.abstracts.LoginController;
import controller.abstracts.RegisterController;
import entity.User;
import service.concretes.UserServiceManager;

public class UserControllerManager implements LoginController, RegisterController {
    private final UserServiceManager userServiceManager = new UserServiceManager();

    @Override
    public Boolean login(String username, String password) {
        return userServiceManager.getAll().stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    @Override
    public Boolean register(String username, String password) {
        if (userServiceManager.checkUsername(username)) {
            return false;
        } else {
            User user = new User(username, password);
            return userServiceManager.create(user);
        }
    }
}
