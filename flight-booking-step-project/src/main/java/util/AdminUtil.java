package util;

import exception.AdminNotFoundException;
import static util.MenuUtil.noticeManager;

public class AdminUtil {

    public static String checkingAdminMenu() throws AdminNotFoundException {
        String origin;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2"))) {
            throw new AdminNotFoundException("Value must be 1 or 2");
        }
        return origin;
    }
}
