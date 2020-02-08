package com.twu.biblioteca;

import java.util.List;

class Library {
    private List<Book> books;

    Library(){
        init();
    }

    private void init() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist","Paulo Coelho", 1990);

        books = List.of(book1,book2,book3);
    }

    public List<Book> getBooks() {
        return books;
    }
}
