package com.twu.biblioteca;

import UI.AppUI;

public class ListOfBook extends MenuOption {
    private Library library;
    private static final ListOfBook INSTANCE = new ListOfBook();

    private ListOfBook() {
        super();
    }

    public static ListOfBook createListOfBooksOption(Library library, AppUI appUI) {
        INSTANCE.appUI = appUI;
        INSTANCE.library = library;
        INSTANCE.name = "List Of Books";

        return INSTANCE;
    }

    @Override
    public void execute() {
        appUI.displayListOfBooks(library.getBooks());
    }
}
