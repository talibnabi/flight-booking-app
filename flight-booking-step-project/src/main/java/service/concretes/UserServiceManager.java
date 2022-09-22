package service.concretes;

import dao.concretes.UserDAOManager;
import entity.User;
import service.abstracts.UserService;

import java.util.List;
import java.util.Optional;

public final class UserServiceManager implements UserService<User> {
    private final UserDAOManager userDAOManager = new UserDAOManager();

    @Override
    public List<User> getAll() {
        return userDAOManager.getAll().orElseThrow();
    }

    @Override
    public User getById(int id) {
        return userDAOManager.getById(id).orElseThrow();
    }

    @Override
    public Boolean create(User object) {
        return userDAOManager.create(object);
    }

    @Override
    public Boolean delete(int id) {
        return userDAOManager.delete(id);
    }

    @Override
    public Boolean checkUsername(String username) {
        return getAll().stream().anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public Optional<User> getCheckedUser(String username, String password) {
        Optional<User> checkedUser = getAll().stream().filter(user -> user.getUsername().equals(username)).findAny();
        if (checkedUser.isPresent() && checkedUser.orElseThrow().getPassword().equals(password)) {
            return checkedUser;
        }
        return Optional.empty();
    }

}
