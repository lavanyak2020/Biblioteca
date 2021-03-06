package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.execption.*;

public abstract class MenuOption {
    protected String name;
    protected PresentationInterface presentationInterface;

    protected MenuOption() {
    }

    public String getName() {
        return name;
    }

    public abstract void execute() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable, ItemIsNotCheckout;
}
