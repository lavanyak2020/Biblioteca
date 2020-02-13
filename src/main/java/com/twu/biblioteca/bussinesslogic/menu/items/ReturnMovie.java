package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.Movie;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.execption.ItemDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.ItemIsNotCheckout;

public class ReturnMovie extends MenuOption {
    private Library library;

    public ReturnMovie(Library library, PresentationInterface presentationInterface) {
        this.library = library;
        this.presentationInterface = presentationInterface;
        this.name = "Return Movie";
    }

    @Override
    public void execute() throws ItemDoesNotBelongToLibrary, ItemIsNotCheckout {
        Movie movie = presentationInterface.getMovieFromUser();
        User user = presentationInterface.getUser();
        library.returnItem(movie, user);
        presentationInterface.showMovieReturnSuccess();
    }
}
