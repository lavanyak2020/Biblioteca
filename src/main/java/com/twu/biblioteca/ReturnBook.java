package com.twu.biblioteca;

import UI.AppUI;

public class ReturnBook extends MenuOption {
    private Library library;
    private static final ReturnBook INSTANCE = new ReturnBook();

    private ReturnBook() {
        super();
    }

    public static ReturnBook createReturnBookOption(Library library, AppUI appUI) {
        INSTANCE.appUI = appUI;
        INSTANCE.library = library;
        INSTANCE.name = "Return Book";

        return INSTANCE;
    }

    @Override
    public void execute() {
        String bookName = appUI.getBookNameFromUser();
        String message = library.returnBook(bookName);
        appUI.displayMessage(message);
    }
}