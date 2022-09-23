package app;


import static util.MenuUtil.menuManager;
import static util.MenuUtil.noticeManager;


public class ApplicationMainMenu {
    public static void showMenuInfo() {
        try {
            menuManager.menu();
        } catch (Exception exception) {
            noticeManager.print("Something went wrong");
        }
    }
}
