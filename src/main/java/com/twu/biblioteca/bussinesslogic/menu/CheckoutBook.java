package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.execption.ItemDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.ItemIsNotAvailable;

public class CheckoutBook extends MenuOption {
    private Library library;
    private static final CheckoutBook INSTANCE = new CheckoutBook();

    private CheckoutBook() {
        super();
    }

    public static CheckoutBook createCheckoutBookOption(Library library, PresentationInterface presentationInterface) {
        INSTANCE.presentationInterface = presentationInterface;
        INSTANCE.library = library;
        INSTANCE.name = "Checkout Book";

        return INSTANCE;
    }

    @Override
    public void execute() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
        Book book = presentationInterface.getBookFromUser();
        User user = presentationInterface.getUser();
        library.checkoutItem(book, user);
        presentationInterface.showCheckoutSuccess();
    }
}
