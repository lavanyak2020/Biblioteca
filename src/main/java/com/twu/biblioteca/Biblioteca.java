package com.twu.biblioteca;

import UI.AppUI;

import java.util.List;

import static com.twu.biblioteca.Message.*;

public class Biblioteca {
    private Library library;
    private Menu menu;

    public Biblioteca(AppUI appUI) {
        library = new Library();
        menu = new Menu(library, appUI);
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<MenuOption> getMenuItems() {
        return menu.menuOptions();
    }

    public void execute(int userInput) {
        menu.executeOption(userInput);
    }
}
