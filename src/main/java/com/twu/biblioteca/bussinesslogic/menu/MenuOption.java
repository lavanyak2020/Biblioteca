package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public abstract class MenuOption {
    protected String name;
    protected PresentationInterface presentationInterface;

    protected MenuOption() {
    }

    public String getName() {
        return name;
    }

    public abstract void execute();
}
