package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotAvailable;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;

public abstract class MenuOption {
    protected String name;
    protected PresentationInterface presentationInterface;

    protected MenuOption() {
    }

    public String getName() {
        return name;
    }

    public abstract void execute() throws BookDoesNotBelongToLibrary, BookIsNotAvailable, BookIsNotCheckout;
}