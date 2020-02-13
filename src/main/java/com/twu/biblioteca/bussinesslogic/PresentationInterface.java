package com.twu.biblioteca.bussinesslogic;

import java.util.HashMap;
import java.util.List;

public interface PresentationInterface {

    void listOfBooks(List<LibraryItem> books);

    void quitApplication();

    Book getBookFromUser();

    void showCheckoutSuccess();

    void showReturnSuccess();

    void listOfMovies(List<LibraryItem> movies);

    Movie getMovieFromUser();

    void showMovieCheckoutSuccess();

    void showMovieReturnSuccess();

    String[] getLoginDetails();

    void showSuccessLogin(User user);

    void showUnsuccessLogin();

    void showCheckoutBooksList(HashMap<LibraryItem, User> userCheckOutBookList);

    User getUser();

    void showCheckoutMoviesList(HashMap<LibraryItem, User> userCheckOutMovieList);

    void showSuccessLogOut();

    void showProfile(User user);
}
