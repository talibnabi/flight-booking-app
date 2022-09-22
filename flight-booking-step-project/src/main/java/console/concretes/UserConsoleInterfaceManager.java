package console.concretes;

import console.abstracts.ShowConsoleInterface;

import static util.MenuUtil.noticeManager;
import static util.MenuUtil.ACCESS_UI_PAGE;

public final class UserConsoleInterfaceManager implements ShowConsoleInterface {
    @Override
    public void showInterface() {
        noticeManager.print(ACCESS_UI_PAGE.showInterface());
    }
}
