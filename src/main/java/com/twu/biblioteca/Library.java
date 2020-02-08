package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.Message.*;

class Library {
    private List<Book> books;

    Library() {
        init();
    }

    private void init() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist", "Paulo Coelho", 1990);

        books = List.of(book1, book2, book3);
    }

    public List<Book> getBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public String checkoutBook(String bookName) {
        Book book = getBookByName(bookName);
        if (book != null && book.isAvailable()) {
            book.checkout();
            return CHECKOUT_SUCCESS_MESSAGE;
        }
        return CHECKOUT_UNSUCCESS_MESSAGE;
    }

    public String returnBook(String bookName) {
        Book book = getBookByName(bookName);
        if (book != null && !book.isAvailable()) {
            book.returned();
            return RETURN_SUCCESS_MESSAGE;
        }
        return RETURN_UNSUCCESS_MESSAGE;
    }

    private Book getBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }
}
