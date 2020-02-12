package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public class ListBooks extends MenuOption {
    private Library library;
    private static final ListBooks INSTANCE = new ListBooks();

    private ListBooks() {
        super();
    }

    public static ListBooks createListOfBooksOption(Library library, PresentationInterface presentationInterface) {
        INSTANCE.presentationInterface = presentationInterface;
        INSTANCE.library = library;
        INSTANCE.name = "List Of Books";

        return INSTANCE;
    }

    @Override
    public void execute() {
        presentationInterface.listOfBooks(library.getAvailableBooks());
    }
}
