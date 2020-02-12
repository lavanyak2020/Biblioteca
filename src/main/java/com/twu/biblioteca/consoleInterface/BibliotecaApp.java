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
        menuOptions.add(ListBooks.createListOfBooksOption(library, appUI));
        menuOptions.add(new ListMovies(library, appUI));
        menuOptions.add(CheckoutBook.createCheckoutBookOption(library, appUI));
        menuOptions.add(new CheckoutMovie(library, appUI));
        menuOptions.add(ReturnBook.createReturnBookOption(library, appUI));
        menuOptions.add(QuitOption.createQuitOption(appUI));
    }
}
