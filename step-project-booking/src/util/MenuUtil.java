package util;

import console.concretes.NoticeManager;
import exception.UserMenuValueNotFoundException;

public class MenuUtil {
    public static final NoticeManager noticeManager = new NoticeManager();

    public static String username() {
        noticeManager.print("Username:");
        return noticeManager.readline();
    }

    public static String password() {
        noticeManager.print("Password: ");
        return noticeManager.readline();
    }

    public static String checking() throws UserMenuValueNotFoundException {
        String origin = null;
        noticeManager.print("Select: ");
        origin = noticeManager.readline();
        if (!(origin.equals("1") || origin.equals("2") || origin.equals("3"))) {
            throw new UserMenuValueNotFoundException("Value must be 1,2 or 3");
        }
        return origin;
    }
}
