package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.Movie;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.execption.ItemDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.ItemIsNotAvailable;

public class CheckoutMovie extends MenuOption {
    private Library library;

    public CheckoutMovie(Library library, PresentationInterface presentationInterface) {
        this.library = library;
        this.presentationInterface = presentationInterface;
        this.name = "Checkout Movie";
    }

    @Override
    public void execute() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
        Movie movie = presentationInterface.getMovieFromUser();
        User user = presentationInterface.getUser();
        library.checkoutItem(movie, user);
        System.out.println("lllll");
        presentationInterface.showMovieCheckoutSuccess();
    }
}
