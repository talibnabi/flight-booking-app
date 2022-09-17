package enumeration.concretes.service;

import dao.abstracts.DAO;
import dao.concretes.UserDAOManager;
import entity.User;
import enumeration.abstracts.DAOWorker;

import java.util.function.Supplier;

public enum UserDAOServiceWorker implements DAOWorker<User> {
    USER_DAO_SERVICE_WORKER(UserDAOManager::new);
    private final Supplier<DAO<User>> userDAOManager;

    UserDAOServiceWorker(Supplier<DAO<User>> userDAOManager) {
        this.userDAOManager = userDAOManager;
    }

    @Override
    public Supplier<DAO<User>> constructor() {
        return userDAOManager;
    }
}
