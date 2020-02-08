package com.twu.biblioteca;

import UI.AppUI;

import java.util.List;

public class Biblioteca {
    private final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final AppUI appUI;
    private Library library;
    private Menu menu;

    public Biblioteca(AppUI appUI) {
        library = new Library();
        this.appUI = appUI;
        menu = new Menu(library,appUI);
    }
    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<MenuOption> getMenuItems() {
        return menu.getMenuOption();
    }
}
