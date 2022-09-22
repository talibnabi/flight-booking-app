package controller.concretes;

import controller.abstracts.UserLoginController;
import controller.abstracts.UserRegisterController;
import entity.User;
import service.concretes.UserServiceManager;

public class UserControllerManager implements UserLoginController, UserRegisterController {
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
