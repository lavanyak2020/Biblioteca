package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import static com.twu.biblioteca.Message.*;

class Library {
    private List<Book> books;
    private List<Book> availableBooks = new ArrayList<>();

    Library() {
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

    public String checkoutBook(Book book) {
        if (book != null && isAvailable(book)) {
            availableBooks.remove(book);
            return CHECKOUT_SUCCESS_MESSAGE;
        }
        return CHECKOUT_UNSUCCESS_MESSAGE;
    }


    public String returnBook(Book book) {
        if (book != null && !isAvailable(book)) {
            availableBooks.add(book);
            return RETURN_SUCCESS_MESSAGE;
        }
        return RETURN_UNSUCCESS_MESSAGE;
    }

    private boolean isAvailable(Book book) {
        return availableBooks.contains(book);
    }
}
