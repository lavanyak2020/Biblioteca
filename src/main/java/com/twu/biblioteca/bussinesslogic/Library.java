package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.execption.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<Movie> movies;
    private final List<Book> availableBooks = new ArrayList<>();
    private List<Movie> availableMovies = new ArrayList<>();
    private HashMap<Book, User> userCheckOutBookList = new HashMap<>();
    private HashMap<Movie, User> userCheckOutMovieList = new HashMap<>();

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.movies = movies;
        availableBooks.addAll(books);
        availableMovies.addAll(movies);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public void checkoutBook(Book book, User user) throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
        if (!isBelongToLibrary(book) || book == null) {
            throw new BookDoesNotBelongToLibrary();
        }
        if (isAvailable(book)) {
            availableBooks.remove(book);
            userCheckOutBookList.put(book, user);
            return;
        }
        throw new BookIsNotAvailable();
    }

    public void checkoutMovie(Movie movie, User user) throws MovieIsNotAvailable, MovieDoesNotBelongToLibrary {
        if (!isBelongToLibrary(movie) || movie == null) {
            throw new MovieDoesNotBelongToLibrary();
        }
        if (isAvailable(movie)) {
            availableMovies.remove(movie);
            userCheckOutMovieList.put(movie, user);
            return;
        }
        throw new MovieIsNotAvailable();
    }

    public void returnBook(Book book, User user) throws BookDoesNotBelongToLibrary, BookIsNotCheckout {
        if (!isBelongToLibrary(book) || book == null) {
            throw new BookDoesNotBelongToLibrary();
        }
        if (!isAvailable(book) && (userCheckOutBookList.get(book) == user)) {
            availableBooks.add(book);
            userCheckOutBookList.remove(book);
            return;
        }
        throw new BookIsNotCheckout();
    }

    public void returnMovie(Movie movie, User user) throws MovieIsNotCheckout, MovieDoesNotBelongToLibrary {
        if (!isBelongToLibrary(movie) || movie == null) {
            throw new MovieDoesNotBelongToLibrary();
        }
        if (!isAvailable(movie) && (userCheckOutMovieList.get(movie) == user)) {
            availableMovies.add(movie);
            userCheckOutMovieList.remove(movie);
            return;
        }
        throw new MovieIsNotCheckout();
    }

    public HashMap<Book, User> getUserCheckOutBookList() {
        return userCheckOutBookList;
    }

    private boolean isBelongToLibrary(Book book) {
        return books.contains(book);
    }

    private boolean isBelongToLibrary(Movie movie) {
        return movies.contains(movie);
    }

    private boolean isAvailable(Book book) {
        return availableBooks.contains(book);
    }

    private boolean isAvailable(Movie movie) {
        return availableMovies.contains(movie);
    }
}
