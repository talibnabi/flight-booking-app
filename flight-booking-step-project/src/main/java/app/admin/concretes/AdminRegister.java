package app.admin.concretes;

import entity.Admin;

import static util.AccessMenuUtil.adminPassword;
import static util.AccessMenuUtil.adminUsername;
import static util.MenuUtil.*;

public final class AdminRegister {
    public static void main(String[] args) {
        //admin name: admin
        //admin password: admin123
        Boolean checked = adminRegister();
    }

    private static Boolean adminRegister() {
        if (adminServiceManager.checkUsername(adminUsername())) {
            System.out.println("Admin already exists....");
            return false;
        } else {
            Admin admin1 = new Admin(adminUsername(), adminPassword());
            return adminServiceManager.create(admin1);
        }
    }
}
