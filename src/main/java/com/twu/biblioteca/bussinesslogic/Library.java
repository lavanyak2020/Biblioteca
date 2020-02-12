package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotAvailable;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;
import com.twu.biblioteca.bussinesslogic.execption.MovieIsNotAvailable;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<Movie> movies;
    private final List<Book> availableBooks = new ArrayList<>();
    private List<Movie> availableMovies = new ArrayList<>();

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

    public void checkoutBook(Book book) throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
        if (!isBelongToLibrary(book) || book == null) {
            throw new BookDoesNotBelongToLibrary();
        }
        if (isAvailable(book)) {
            availableBooks.remove(book);
            return;
        }
        throw new BookIsNotAvailable();
    }

    public void checkoutMovie(Movie movie) throws MovieIsNotAvailable {
        if (isAvailable(movie)) {
            availableMovies.remove(movie);
            return;
        }
        throw new MovieIsNotAvailable();
    }

    private boolean isAvailable(Movie movie) {
        return availableMovies.contains(movie);
    }

    public void returnBook(Book book) throws BookDoesNotBelongToLibrary, BookIsNotCheckout {
        if (!isBelongToLibrary(book) || book == null) {
            throw new BookDoesNotBelongToLibrary();
        }
        if (!isAvailable(book)) {
            availableBooks.add(book);
            return;
        }
        throw new BookIsNotCheckout();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    private boolean isBelongToLibrary(Book book) {
        return books.contains(book);
    }

    private boolean isAvailable(Book book) {
        return availableBooks.contains(book);
    }
}
