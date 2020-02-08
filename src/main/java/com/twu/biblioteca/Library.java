package com.twu.biblioteca;

import java.util.List;

class Library {
    private List<Book> books;

    Library(){
        init();
    }

    private void init() {
        Book book1 = new Book("Quantitative Aptitude");
        Book book2 = new Book("Head First Java");
        Book book3 = new Book("Introduction to algorithms");

        books = List.of(book1,book2,book3);
    }

    public List<Book> getBooks() {
        return books;
    }
}
