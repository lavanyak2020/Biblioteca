package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public class ShowCheckoutBookDetails extends MenuOption {
    private final Library library;
    private final PresentationInterface presentationInterface;

    public ShowCheckoutBookDetails(Library library, PresentationInterface presentationInterface) {
        this.name = "Show Checkout Books Details";
        this.library = library;
        this.presentationInterface = presentationInterface;
    }

    @Override
    public void execute() {
        presentationInterface.showCheckoutBooksList(library.getUserCheckOutItemList());
    }
}
