package console.abstracts;

import exception.UserMenuValueNotFoundException;

public interface UserMenu {
    void showPage();
    void menu() throws UserMenuValueNotFoundException;
}
