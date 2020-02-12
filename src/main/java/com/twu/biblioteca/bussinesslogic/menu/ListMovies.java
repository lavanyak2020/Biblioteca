package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public class ListMovies extends MenuOption {
    private final Library library;

    public ListMovies(Library library, PresentationInterface presentationInterface) {
        this.library = library;
        this.presentationInterface = presentationInterface;
        this.name = "List Of Movies";
    }
    @Override
    public void execute() {
        presentationInterface.listOfMovies(library.getAvailableMovies());
    }
}
