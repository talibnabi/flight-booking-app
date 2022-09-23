package ui.concretes;

import ui.abstracts.Menu;

public class AdminUIPage implements Menu {
    @Override
    public String showInterface() {
        return "===========================================\n" +
                "||->          ADMIN PAGE              <-||\n" +
                "==========================================\n" +
                "| What do you want to do?                |\n" +
                "| 1. --> FILL FLIGHTS RANDOMLY           |\n" +
                "| 2. --> LOG OUT                         |\n" +
                "|========================================|\n";
    }
}
