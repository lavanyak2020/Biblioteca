package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.menu.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    ConsoleInterface appUI;
    Library library;
    private List<MenuOption> menuOptions;

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        library = new Library();
        appUI = new ConsoleInterface(library.getBooks());
        initializeMenu(library, appUI);
        appUI.message(getWelcomeMessage());
        do {
            appUI.displayMenu(menuOptions);
            int userInput = appUI.getUserInput();
            executeOption(userInput - 1);
        } while (true);
    }

    private String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    private void executeOption(int optionIndex) {
        if (optionIndex < 0 || optionIndex >= menuOptions.size()) {
            appUI.message("Invalid Option");
            return;
        }
        menuOptions.get(optionIndex).execute();
    }

    private void initializeMenu(Library library, ConsoleInterface appUI) {
        menuOptions = new ArrayList<>();
        menuOptions.add(ListOfBook.createListOfBooksOption(library, appUI));
        menuOptions.add(CheckoutBook.createCheckoutBookOption(library, appUI));
        menuOptions.add(ReturnBook.createReturnBookOption(library, appUI));
        menuOptions.add(QuitOption.createQuitOption(appUI));
    }
}
