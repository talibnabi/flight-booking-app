package dao.concretes;

import dao.abstracts.DAO;
import entity.User;
import enumeration.concretes.data.PassengerDataSource;
import enumeration.concretes.data.UserDataSource;
import enumeration.concretes.file.FilePathAccess;
import enumeration.concretes.file.PassengerFileWorker;
import enumeration.concretes.file.UserFileWorker;

import java.util.Collection;
import java.util.Optional;

public class UserDAOManager implements DAO<User> {
    @Override
    public Optional<Collection<User>> getAll() {
        return Optional.ofNullable(
                UserFileWorker
                        .USER_FILE_WORKER
                        .constructor()
                        .get()
                        .readListFromFile(FilePathAccess
                                .USER_DATA
                                .getFilePath()));
    }

    @Override
    public Boolean create(User data) {
        UserDataSource
                .USER_DATA_SOURCE
                .constructor()
                .get()
                .add(data);
        return writeToFile();
    }

    @Override
    public Boolean deleteFromFile(int id) {
        UserDataSource
                .USER_DATA_SOURCE
                .constructor()
                .get()
                .removeIf(
                        user -> id == user.getUserId()
                );
        return writeToFile();
    }

    @Override
    public Boolean writeToFile() {
        return UserFileWorker
                .USER_FILE_WORKER
                .constructor()
                .get()
                .writeListToFile(
                        FilePathAccess
                                .USER_DATA
                                .getFilePath(),
                        UserDataSource
                                .USER_DATA_SOURCE
                                .constructor()
                                .get()
                );
    }
}
