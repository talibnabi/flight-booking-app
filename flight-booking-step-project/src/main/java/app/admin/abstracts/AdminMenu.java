package app.admin.abstracts;

import exception.AdminNotFoundException;

public interface AdminMenu {
    void showPage();

    void menu() throws AdminNotFoundException;
}
