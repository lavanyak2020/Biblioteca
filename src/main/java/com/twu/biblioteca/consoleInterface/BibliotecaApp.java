package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.menu.items.*;
import com.twu.biblioteca.bussinesslogic.menu.menulist.CustomerMenuList;
import com.twu.biblioteca.bussinesslogic.menu.menulist.DefaultMenuList;
import com.twu.biblioteca.bussinesslogic.menu.menulist.LibrarianMenuList;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.bussinesslogic.UserType.*;
import static com.twu.biblioteca.consoleInterface.Message.*;
import static com.twu.biblioteca.datalayer.Data.*;

public class BibliotecaApp {
    private ConsoleInterface appUI;
    private Library library;
    private List<MenuOption> defaultMenuOptions = new ArrayList<>();
    private List<User> users;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        List<Book> books = getBooks();

        List<Movie> movies = getMovies();

        bibliotecaApp.users = getUsers();

        bibliotecaApp.library = new Library(books, movies);

        bibliotecaApp.appUI = new ConsoleInterface(books, movies);

        DefaultMenuList defaultMenuList = new DefaultMenuList(bibliotecaApp.library, bibliotecaApp.users, bibliotecaApp.appUI);

        bibliotecaApp.defaultMenuOptions = defaultMenuList.getMenuOptions();

        LibrarianMenuList librarianMenuList = new LibrarianMenuList(bibliotecaApp.library, bibliotecaApp.appUI);

        CustomerMenuList customerMenuList = new CustomerMenuList(bibliotecaApp.library, bibliotecaApp.appUI);

        LIBRARIAN.setMenuOptions(librarianMenuList.getMenuOptions());

        CUSTOMER.setMenuOptions(customerMenuList.getMenuOptions());

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
