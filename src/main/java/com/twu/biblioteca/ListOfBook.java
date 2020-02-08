package com.twu.biblioteca;

import UI.AppUI;

public class ListOfBook extends MenuOption {
    private Library library;

    public ListOfBook(Library library, AppUI appUI) {
        super("List Of Books", appUI);
        this.library = library;
    }

    @Override
    public void execute() {
        appUI.displayListOfBooks(library.getBooks());
    }
}
