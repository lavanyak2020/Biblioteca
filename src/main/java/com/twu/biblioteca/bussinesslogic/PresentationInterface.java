package com.twu.biblioteca.bussinesslogic;

import java.util.HashMap;
import java.util.List;

public interface PresentationInterface {

    void listOfBooks(List<Book> books);

    void quitApplication();

    Book getBookFromUser();

    void showCheckoutSuccess();

    void showReturnSuccess();

    void listOfMovies(List<Movie> movies);

    Movie getMovieFromUser();

    void showMovieCheckoutSuccess();

    void showMovieReturnSuccess();

    String[] getLoginDetails();

    void showSuccessLogin(User user);

    void showUnsuccessLogin();

    void showCheckoutBooksList(HashMap<Book, User> userCheckOutBookList);

    User getUser();

    void showCheckoutMoviesList(HashMap<Movie, User> userCheckOutMovieList);

    void showSuccessLogOut();
}
