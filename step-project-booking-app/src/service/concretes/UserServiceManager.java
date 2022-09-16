package service.concretes;

import entity.User;
import service.abstracts.UserService;

import java.util.Optional;

public class UserServiceManager implements UserService {

    @Override
    public Optional<User> signIn(String username, String password) {
        return Optional.empty();
    }

    @Override
    public Boolean signUp(User user) {
        return null;
    }

    @Override
    public Boolean checking(String username) {
        return null;
    }
}
