package app.admin.concretes;

import app.admin.abstracts.ShowAdminInterfaceMenu;

import static util.MenuUtil.*;

public class AdminMenuInterfaceManager implements ShowAdminInterfaceMenu {
    @Override
    public void showAdminMenuInterface() {
        noticeManager.print(ADMIN_UI_PAGE.showInterface());
    }
}
