package console.concretes;

import console.abstracts.ShowConsoleInterface;

import static util.MenuUtil.noticeManager;
import static util.MenuUtil.userUIPage;

public class UserConsoleInterfaceManager implements ShowConsoleInterface {
    @Override
    public void showInterface() {
        noticeManager.print(userUIPage.showInterface());
    }
}
