package com.twu.biblioteca;

import UI.AppUI;

public class QuitOption extends MenuOption {
    private static final QuitOption INSTANCE = new QuitOption();

    private QuitOption() {
        super();
    }

    public static QuitOption createQuitOption(AppUI appUI) {
        INSTANCE.appUI = appUI;
        INSTANCE.name = "Quit";

        return INSTANCE;
    }

    @Override
    public void execute() {
        appUI.quitApplication();
    }
}
