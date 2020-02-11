package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public class ListOfBook extends MenuOption {
    private Library library;
    private static final ListOfBook INSTANCE = new ListOfBook();

    private ListOfBook() {
        super();
    }

    public static ListOfBook createListOfBooksOption(Library library, PresentationInterface presentationInterface) {
        INSTANCE.presentationInterface = presentationInterface;
        INSTANCE.library = library;
        INSTANCE.name = "List Of Books";

        return INSTANCE;
    }

    @Override
    public void execute() {
        presentationInterface.listOfBooks(library.getBooks());
    }
}
