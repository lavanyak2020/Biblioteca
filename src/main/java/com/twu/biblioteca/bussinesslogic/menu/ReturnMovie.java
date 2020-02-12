package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.Movie;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;
import com.twu.biblioteca.bussinesslogic.execption.MovieDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.MovieIsNotCheckout;

public class ReturnMovie extends MenuOption {
    private Library library;

    public ReturnMovie(Library library, PresentationInterface presentationInterface) {
        this.library = library;
        this.presentationInterface = presentationInterface;
        this.name = "Return Movie";
    }

    @Override
    public void execute() throws MovieDoesNotBelongToLibrary, MovieIsNotCheckout {
        Movie movie = presentationInterface.getMovieFromUser();
        library.returnMovie(movie);
        presentationInterface.showMovieReturnSuccess();
    }
}
