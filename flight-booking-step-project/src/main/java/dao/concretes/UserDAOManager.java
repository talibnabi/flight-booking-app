package dao.concretes;

import dao.abstracts.UserDAO;
import entity.User;
import file.abstracts.FilePath;
import file.abstracts.FileWorking;
import file.concretes.WorkingWithFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOManager implements UserDAO<User>, FilePath<User> {
    private final FileWorking<User> fileWorking = new WorkingWithFile<>();

    @Override
    public Optional<List<User>> getAll() {
        return Optional.ofNullable(fileWorking.readListFromFile(getFilePath()));
    }

    @Override
    public Optional<User> getById(int id) {
        return Optional.ofNullable(getAll().orElseThrow().stream().filter(user -> user.getId() == id).toList().get(0));
    }

    @Override
    public Boolean create(User object) {
        List<User> userList = new ArrayList<>(getAll().orElseThrow());
        userList.add(object);
        return fileWorking.writeListToFile(getFilePath(), userList);
    }

    @Override
    public Boolean delete(int id) {
        return fileWorking.writeListToFile(getFilePath(), getAll().orElseThrow().stream().filter(user -> user.getId() != id).toList());
    }

    @Override
    public String getFilePath() {
        return "db/datasource/user.bin";
    }
}
