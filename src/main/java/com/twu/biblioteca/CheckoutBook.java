package com.twu.biblioteca;

import UI.AppUI;

public class CheckoutBook extends MenuOption{
    private Library library;
    private static final CheckoutBook INSTANCE = new CheckoutBook();

    private CheckoutBook() {
        super();
    }

    public static CheckoutBook createCheckoutBookOption(Library library, AppUI appUI) {
        INSTANCE.appUI = appUI;
        INSTANCE.library = library;
        INSTANCE.name = "Checkout Book";

        return INSTANCE;
    }

    @Override
    public void execute() {
        String bookName = appUI.getBookNameFromUser();
        library.checkoutBook(bookName);
    }
}
