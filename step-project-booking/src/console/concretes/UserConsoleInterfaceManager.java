package console.concretes;

import console.abstracts.ShowConsoleInterface;
import ui.concretes.UserUIPage;

public class UserConsoleInterfaceManager implements ShowConsoleInterface {
    private final NoticeManager noticeManager = new NoticeManager();
    private final UserUIPage userUIPage = new UserUIPage();

    @Override
    public void showInterface() {
        noticeManager.print(userUIPage.showInterface());
    }
}
