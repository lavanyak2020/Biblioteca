package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public class ShowCheckoutMoviesDetails extends MenuOption {
    private final Library library;
    private final PresentationInterface presentationInterface;

    public ShowCheckoutMoviesDetails(Library library, PresentationInterface presentationInterface) {
        this.name = "Show Checkout Movies Details";
        this.library = library;
        this.presentationInterface = presentationInterface;
    }

    @Override
    public void execute() {
        presentationInterface.showCheckoutMoviesList(library.getUserCheckOutItemList());
    }
}
