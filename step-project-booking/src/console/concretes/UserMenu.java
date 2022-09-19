package console.concretes;

import controller.concretes.UserControllerManager;
import service.concretes.UserServiceManager;

public class UserMenu {
    private final UserServiceManager userServiceManager=new UserServiceManager();
    private final NoticeManager noticeManager = new NoticeManager();
    private final UserConsoleManager userConsoleManager = new UserConsoleManager();
    private final UserControllerManager userControllerManager = new UserControllerManager();

    public static void main(String[] args) {
        UserMenu userMenu = new UserMenu();
        userMenu.showPage();
        userMenu.menu();
    }

    private void showPage() {
        userConsoleManager.showUserInfo();
    }

    private void menu() {
        noticeManager.print("Select: ");
        String origin = noticeManager.readline();
        switch (origin) {
            case "1":
                noticeManager.print("Username: ");
                String username = noticeManager.readline();
                noticeManager.print("Password: ");
                String password = noticeManager.readline();
                if(userControllerManager.login(username, password)){
                    userServiceManager.getAll().forEach(System.out::println);
                }
                else {
                    System.out.println("no");
                }
                break;
            case "2":
                noticeManager.print("Username: ");
                String usernameRegister = noticeManager.readline();
                noticeManager.print("Password: ");
                String passwordRegister = noticeManager.readline();
                userControllerManager.register(usernameRegister, passwordRegister);
                showPage();
                menu();
                break;
            case "3":
                System.exit(0);
        }
    }
}
