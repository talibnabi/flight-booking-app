package controller.concretes;

import controller.abstracts.AdminLoginController;
import controller.abstracts.AdminRegisterController;
import entity.Admin;
import service.concretes.AdminServiceManager;

public class AdminControllerManager implements AdminLoginController, AdminRegisterController {
    private final AdminServiceManager adminServiceManager = new AdminServiceManager();

    @Override
    public Boolean login(String username, String password) {
        return adminServiceManager.getAll().stream().anyMatch(admin -> admin.getUsername().equals(username) && admin.getPassword().equals(password));
    }

    @Override
    public Boolean register(String username, String password) {
        Admin admin = new Admin(username, password);
        return adminServiceManager.create(admin);
    }
}
