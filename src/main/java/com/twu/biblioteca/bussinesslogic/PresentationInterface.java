package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.Book;

import java.util.List;

public interface PresentationInterface {
    void listOfBooks(List<Book> books);

    void message(String message);

    void quitApplication();

    Book getBookFromUser();
}
