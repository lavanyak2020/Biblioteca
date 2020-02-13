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

public class BibliotecaApp {
    private ConsoleInterface appUI;
    private Library library;
    private List<MenuOption> defaultMenuOptions = new ArrayList<>();
    private List<User> users;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Beauty", " Sheri S. Tepper", 1991);
        Book book3 = new Book("Alphabet of Thorn", "Patricia McKillip", 2004);
        List<Book> books = List.of(book1, book2, book3);
        Movie movie1 = new Movie("Ala Vaikunta Puramlo", "Trivikram Srinivas", 2020, 10);
        Movie movie2 = new Movie("Sarileru Neekevaru", "Anil Ravipudi", 2020, 5);
        Movie movie3 = new Movie("Jaanu", "Prem Kumar", 2020, 8);
        List<Movie> movies = List.of(movie1, movie2, movie3);
        bibliotecaApp.library = new Library(books, movies);
        bibliotecaApp.appUI = new ConsoleInterface(books, movies);
        bibliotecaApp.users = new ArrayList<>();
        User user = new User("123-0001", "1234", "lavanya", "lavanya@gmail.com", "8096724925", CUSTOMER);
        User librarian = new User("123-0002", "librarian", "Librarian", "lavanya@gmail.com", "8096724925", LIBRARIAN);
        bibliotecaApp.users.add(user);
        bibliotecaApp.users.add(librarian);
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
