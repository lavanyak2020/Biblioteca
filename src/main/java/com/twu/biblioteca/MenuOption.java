package com.twu.biblioteca;

import UI.AppUI;

public abstract class MenuOption {
    protected String name;
    protected AppUI appUI;

    protected MenuOption() {

    }

    public String getName() {
        return name;
    }

    public abstract void execute();
}
