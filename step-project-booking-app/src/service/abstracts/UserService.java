package service.abstracts;

import entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> signIn(String username, String password);

    Boolean signUp(User user);


}
