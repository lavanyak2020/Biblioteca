package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.menu.*;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.consoleInterface.Message.*;

public class BibliotecaApp {
    private ConsoleInterface appUI;
    private Library library;
    private List<MenuOption> menuOptions;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.library = new Library();
        bibliotecaApp.appUI = new ConsoleInterface(bibliotecaApp.library.getAllBooks());
        bibliotecaApp.start();
    }

    private void start() {
        initializeMenu(library, appUI);
        appUI.displayMessage(WELCOME_MESSAGE);
        do {
            appUI.displayMenu(menuOptions);
            int userInput = appUI.getUserInput();
            appUI.executeOption(userInput - 1, menuOptions);
        } while (true);
    }

    private void initializeMenu(Library library, ConsoleInterface appUI) {
        menuOptions = new ArrayList<>();
        menuOptions.add(ListOfBook.createListOfBooksOption(library, appUI));
        menuOptions.add(CheckoutBook.createCheckoutBookOption(library, appUI));
        menuOptions.add(ReturnBook.createReturnBookOption(library, appUI));
        menuOptions.add(QuitOption.createQuitOption(appUI));
    }
}
