package com.twu.biblioteca;

import UI.AppUI;

import java.util.List;

import static com.twu.biblioteca.ListOfBook.*;

public class Menu {
    List<MenuOption> options;

    public Menu(Library library, AppUI appUI) {
        options = List.of(createListOfBooksOption(library, appUI));
    }

    public List<MenuOption> getMenuOption() {
        return options;
    }
}
