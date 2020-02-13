package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.execption.ItemDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.ItemIsNotCheckout;

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
    public void execute() throws ItemDoesNotBelongToLibrary, ItemIsNotCheckout {
        Book book = presentationInterface.getBookFromUser();
        User user = presentationInterface.getUser();
        library.returnItem(book, user);
        presentationInterface.showReturnSuccess();
    }
}
