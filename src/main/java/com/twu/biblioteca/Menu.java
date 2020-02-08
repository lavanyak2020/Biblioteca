package com.twu.biblioteca;

import UI.AppUI;

import java.util.List;

import static com.twu.biblioteca.ListOfBook.*;

public class Menu {
    private final String INVALID_OPTION_MESSAGE = "Please select a valid option!";
    private final AppUI appUI;
    List<MenuOption> options;

    public Menu(Library library, AppUI appUI) {
        options = List.of(createListOfBooksOption(library, appUI),QuitOption.createQuitOption(appUI));
        this.appUI = appUI;
    }

    public List<MenuOption> getMenuOption() {
        return options;
    }

    public void executeOption(int optionIndex) {
        if (optionIndex < 0 || optionIndex >= options.size())
            appUI.displayMessage(INVALID_OPTION_MESSAGE);
        else
            options.get(optionIndex).execute();
    }
}
