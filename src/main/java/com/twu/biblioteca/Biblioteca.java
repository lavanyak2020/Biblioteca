package com.twu.biblioteca;

import UI.AppUI;

import java.util.List;

import static com.twu.biblioteca.Message.*;

public class Biblioteca {
    private final AppUI appUI;
    private Library library;
    private Menu menu;

    public Biblioteca(AppUI appUI) {
        library = new Library();
        this.appUI = appUI;
        menu = new Menu(library, appUI);
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<MenuOption> getMenuItems() {
        return menu.getMenuOption();
    }

    public void execute(int userInput) {
        menu.executeOption(userInput);
    }
}
