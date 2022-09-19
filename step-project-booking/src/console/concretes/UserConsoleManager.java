package console.concretes;

import console.abstracts.UserConsole;
import ui.concretes.UserUIPage;

public class UserConsoleManager implements UserConsole {
    private final NoticeManager noticeManager = new NoticeManager();
    private final UserUIPage userUIPage = new UserUIPage();

    @Override
    public void showUserInterface() {
        noticeManager.print(userUIPage.showInterface());
    }
}
