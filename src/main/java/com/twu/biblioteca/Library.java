package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

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

    public void checkoutBook(String bookName) {
        Book book = getBookByName(bookName);
        if (book != null && book.isAvailable())
            book.checkout();
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
