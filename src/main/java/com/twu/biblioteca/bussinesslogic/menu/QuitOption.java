package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;

public class QuitOption extends MenuOption {
    private static final QuitOption INSTANCE = new QuitOption();

    private QuitOption() {
        super();
    }

    public static QuitOption createQuitOption(PresentationInterface presentationInterface) {
        INSTANCE.presentationInterface = presentationInterface;
        INSTANCE.name = "Quit";

        return INSTANCE;
    }

    @Override
    public void execute() {
        presentationInterface.quitApplication();
    }
}
