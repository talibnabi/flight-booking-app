package console.concretes;

import console.abstracts.ShowConsoleInterface;

import static util.MenuUtil.bookingUIPage;
import static util.MenuUtil.noticeManager;

public final class FlightBookingConsoleInterfaceManager implements ShowConsoleInterface {

    @Override
    public void showInterface() {
        noticeManager.print(bookingUIPage.showInterface());
    }
}
