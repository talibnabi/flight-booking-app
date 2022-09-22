package dao.concretes;

import dao.abstracts.AdminDAO;
import entity.Admin;
import file.abstracts.FilePath;
import file.abstracts.FileWorking;
import file.concretes.WorkingWithFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AdminDAOManager implements AdminDAO, FilePath<Admin> {
    private final FileWorking<Admin> fileWorking = new WorkingWithFile<>();

    @Override
    public Optional<List<Admin>> getAll() {
        return Optional.ofNullable(fileWorking.readListFromFile(getFilePath()));
    }

    @Override
    public Optional<Admin> getById(int id) {
        return Optional.ofNullable(getAll().orElseThrow().stream().filter(user -> user.getId() == id).toList().get(0));
    }

    @Override
    public Boolean create(Admin object) {
        List<Admin> adminList = new ArrayList<>(getAll().orElseThrow());
        adminList.add(object);
        return fileWorking.writeListToFile(getFilePath(), adminList);
    }

    @Override
    public Boolean delete(int id) {
        return fileWorking.writeListToFile(getFilePath(), getAll().orElseThrow().stream().filter(admin -> admin.getId() != id).toList());
    }
    @Override
    public String getFilePath() {
        return "db/datasource/admin.bin";
    }

}

