package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;

public class ReturnBook extends MenuOption {
    private Library library;
    private static final ReturnBook INSTANCE = new ReturnBook();

    private ReturnBook() {
        super();
    }

    public static ReturnBook createReturnBookOption(Library library, PresentationInterface presentationInterface) {
        INSTANCE.presentationInterface = presentationInterface;
        INSTANCE.library = library;
        INSTANCE.name = "Return Book";

        return INSTANCE;
    }

    @Override
    public void execute() throws BookDoesNotBelongToLibrary, BookIsNotCheckout {
        Book book = presentationInterface.getBookFromUser();
        library.returnBook(book);
        presentationInterface.showReturnSuccess();
    }
}
