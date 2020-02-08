package com.twu.biblioteca;

import java.util.List;

public class Biblioteca {
    private final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private Library library;

    public Biblioteca() {
        library = new Library();
    }
    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getListOfBooks() {
        return library.getBooks();
    }
}
