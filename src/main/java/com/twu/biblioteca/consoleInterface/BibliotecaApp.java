package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.menu.items.*;
import com.twu.biblioteca.bussinesslogic.menu.menulist.MenuList;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.bussinesslogic.UserType.*;
import static com.twu.biblioteca.consoleInterface.Message.*;
import static com.twu.biblioteca.datalayer.Data.*;

public class BibliotecaApp {
    private ConsoleInterface appUI;
    private Library library;
    private List<MenuOption> defaultMenuOptions = new ArrayList<>();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        List<Book> books = getBooks();

        List<Movie> movies = getMovies();

        List<User> users = getUsers();

        bibliotecaApp.library = new Library(books, movies, users);

        bibliotecaApp.appUI = new ConsoleInterface(books, movies);

        MenuList menuList = new MenuList(bibliotecaApp.library, bibliotecaApp.appUI);

        bibliotecaApp.defaultMenuOptions = menuList.getDefaultMenuOptions();

        LIBRARIAN.setMenuOptions(menuList.getLibrarianMenuOptions());

        CUSTOMER.setMenuOptions(menuList.getCustomerMenuOptions());

        bibliotecaApp.start();
    }

    private void start() {
        appUI.displayMessage(WELCOME_MESSAGE);
        List<MenuOption> menu;
        do {
            User user = appUI.getUser();
            if (user == null) {
                menu = defaultMenuOptions;
            } else {
                menu = user.getType().getMenuOption();
            }
            appUI.displayMenu(menu);
            int userInput = appUI.getUserInput();
            appUI.executeOption(userInput - 1, menu);
        } while (true);
    }

}
