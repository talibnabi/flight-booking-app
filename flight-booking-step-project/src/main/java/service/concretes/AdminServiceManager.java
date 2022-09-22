package service.concretes;

import dao.concretes.AdminDAOManager;
import entity.Admin;
import entity.User;
import service.abstracts.AdminService;

import java.util.List;
import java.util.Optional;

public final class AdminServiceManager implements AdminService<Admin> {
    private final AdminDAOManager adminDAOManager = new AdminDAOManager();

    @Override
    public List<Admin> getAll() {
        return adminDAOManager.getAll().orElseThrow();
    }

    @Override
    public Admin getById(int id) {
        return adminDAOManager.getById(id).orElseThrow();
    }

    @Override
    public Boolean create(Admin object) {
        return adminDAOManager.create(object);
    }

    @Override
    public Boolean delete(int id) {
        return adminDAOManager.delete(id);
    }

    @Override
    public Boolean checkUsername(String adminName) {
        return getAll().stream().anyMatch(admin -> admin.getUsername().equals(adminName));
    }

    @Override
    public Optional<Admin> getCheckedUser(String adminName, String adminPassword) {
        Optional<Admin> checkedAdmin = getAll().stream().filter(admin -> admin.getUsername().equals(adminName)).findAny();
        if (checkedAdmin.isPresent() && checkedAdmin.orElseThrow().getPassword().equals(adminPassword)) {
            return checkedAdmin;
        }
        return Optional.empty();
    }
}
