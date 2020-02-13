package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.menu.*;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.bussinesslogic.UserType.*;
import static com.twu.biblioteca.consoleInterface.Message.*;

public class BibliotecaApp {
    private ConsoleInterface appUI;
    private Library library;
    private List<MenuOption> defaultMenuOptions = new ArrayList<>();
    private List<User> users;
    private static ListBooks listBooksOption;
    private static ListMovies listMoviesOption;
    private static LoginOption loginOption;
    private static QuitOption quitOption;
    private static CheckoutBook checkoutBookOption;
    private static UserProfile userProfileOption;
    private static CheckoutMovie checkoutMovieOption;
    private static ReturnBook returnBookOption;
    private static ReturnMovie returnMovieOption;
    private static ShowCheckoutBookDetails showCheckoutBookDetailsOption;
    private static ShowCheckoutMoviesDetails showCheckoutMoviesDetailsOption;
    private static Logout logoutOption;

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
        bibliotecaApp.initializeMenu();
        bibliotecaApp.defaultMenuOptions = List.of(listBooksOption, listMoviesOption, loginOption, quitOption);
        LIBRARIAN.setMenuOptions(
                List.of(
                        listBooksOption,
                        listMoviesOption,
                        checkoutBookOption,
                        checkoutMovieOption,
                        returnBookOption,
                        returnMovieOption,
                        showCheckoutBookDetailsOption,
                        showCheckoutMoviesDetailsOption,
                        logoutOption,
                        userProfileOption,
                        quitOption
                )
        );

        CUSTOMER.setMenuOptions(
                List.of(
                        listBooksOption,
                        listMoviesOption,
                        checkoutBookOption,
                        checkoutMovieOption,
                        returnBookOption,
                        returnMovieOption,
                        logoutOption,
                        userProfileOption,
                        quitOption
                )
        );
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

    private void initializeMenu() {
        listBooksOption = ListBooks.createListOfBooksOption(library, appUI);
        listMoviesOption = new ListMovies(library, appUI);
        loginOption = new LoginOption(users, appUI);
        quitOption = QuitOption.createQuitOption(appUI);
        checkoutBookOption = CheckoutBook.createCheckoutBookOption(library, appUI);
        checkoutMovieOption = new CheckoutMovie(library, appUI);
        returnBookOption = ReturnBook.createReturnBookOption(library, appUI);
        returnMovieOption = new ReturnMovie(library, appUI);
        showCheckoutBookDetailsOption = new ShowCheckoutBookDetails(library, appUI);
        showCheckoutMoviesDetailsOption = new ShowCheckoutMoviesDetails(library, appUI);
        logoutOption = new Logout(appUI);
        userProfileOption = new UserProfile(appUI);
    }
}
