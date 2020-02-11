package com.twu.biblioteca.bussinesslogic;

import java.util.List;

public interface PresentationInterface {
    void listOfBooks(List<Book> books);

    void quitApplication();

    Book getBookFromUser();

    void showCheckoutSuccess();

    void showReturnSuccess();
}
