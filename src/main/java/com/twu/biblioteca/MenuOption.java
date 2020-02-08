package com.twu.biblioteca;

import UI.AppUI;

public abstract class MenuOption {
    protected String name;
    protected AppUI appUI;

    public MenuOption(String name, AppUI appUI) {
        this.name = name;
        this.appUI = appUI;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();
}
