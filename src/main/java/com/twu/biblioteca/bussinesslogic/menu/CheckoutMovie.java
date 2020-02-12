package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.Movie;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.execption.MovieDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.MovieIsNotAvailable;

public class CheckoutMovie extends MenuOption {
    private Library library;

    public CheckoutMovie(Library library, PresentationInterface presentationInterface) {
        this.library = library;
        this.presentationInterface = presentationInterface;
        this.name = "Checkout Movie";
    }

    @Override
    public void execute() throws MovieIsNotAvailable, MovieDoesNotBelongToLibrary {
        Movie movie = presentationInterface.getMovieFromUser();
        library.checkoutMovie(movie);
        presentationInterface.showMovieCheckoutSuccess();
    }
}
