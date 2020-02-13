package com.twu.biblioteca.bussinesslogic.menu.menulist;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.menu.items.*;

import java.util.List;

public class MenuList {
    private final List<MenuOption> defaultMenuOptions;
    private final List<MenuOption> librarianMenuOptions;
    private final List<MenuOption> customerMenuOptions;

    public MenuList(Library library, PresentationInterface presentationInterface) {
        defaultMenuOptions = List.of(
                ListBooks.createListOfBooksOption(library, presentationInterface),
                new ListMovies(library, presentationInterface),
                new LoginOption(library, presentationInterface),
                QuitOption.createQuitOption(presentationInterface)
        );

        librarianMenuOptions = List.of(
                ListBooks.createListOfBooksOption(library, presentationInterface),
                new ListMovies(library, presentationInterface),
                CheckoutBook.createCheckoutBookOption(library, presentationInterface),
                new CheckoutMovie(library, presentationInterface),
                ReturnBook.createReturnBookOption(library, presentationInterface),
                new ReturnMovie(library, presentationInterface),
                new ShowCheckoutBookDetails(library, presentationInterface),
                new ShowCheckoutMoviesDetails(library, presentationInterface),
                new UserProfile(presentationInterface),
                new Logout(presentationInterface),
                QuitOption.createQuitOption(presentationInterface)
        );

        customerMenuOptions = List.of(
                ListBooks.createListOfBooksOption(library, presentationInterface),
                new ListMovies(library, presentationInterface),
                CheckoutBook.createCheckoutBookOption(library, presentationInterface),
                new CheckoutMovie(library, presentationInterface),
                ReturnBook.createReturnBookOption(library, presentationInterface),
                new ReturnMovie(library, presentationInterface),
                new UserProfile(presentationInterface),
                new Logout(presentationInterface),
                QuitOption.createQuitOption(presentationInterface)
        );
    }

    public List<MenuOption> getDefaultMenuOptions() {
        return defaultMenuOptions;
    }

    public List<MenuOption> getLibrarianMenuOptions() {
        return librarianMenuOptions;
    }

    public List<MenuOption> getCustomerMenuOptions() {
        return customerMenuOptions;
    }
}
