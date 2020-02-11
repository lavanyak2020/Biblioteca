package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotAvailable;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Book> availableBooks = new ArrayList<>();

    public Library() {
        init();
    }

    private void init() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist", "Paulo Coelho", 1990);

        books = List.of(book1, book2, book3);
        availableBooks.add(book1);
        availableBooks.add(book2);
        availableBooks.add(book3);
    }

    public List<Book> getBooks() {
        return availableBooks;
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
