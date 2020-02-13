package com.twu.biblioteca.bussinesslogic.menu.menulist;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.menu.items.*;

import java.util.List;

public class CustomerMenuList {
    private final List<MenuOption> menuOptions;

    public CustomerMenuList(Library library, PresentationInterface presentationInterface){
        menuOptions = List.of(
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

    public List<MenuOption> getMenuOptions() {
        return menuOptions;
    }
}
