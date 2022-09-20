package console.concretes;

import console.abstracts.ShowConsoleInterface;
import ui.concretes.BookingUIPage;

public class FlightBookingConsoleInterfaceManager implements ShowConsoleInterface {
    private final NoticeManager noticeManager = new NoticeManager();
    private final BookingUIPage bookingUIPage = new BookingUIPage();

    @Override
    public void showInterface() {
        noticeManager.print(bookingUIPage.showInterface());
    }
}
