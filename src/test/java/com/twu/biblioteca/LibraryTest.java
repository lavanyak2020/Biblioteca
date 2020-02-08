package com.twu.biblioteca;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LibraryTest {

    @Test
    public void shouldReturnAllBooks() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist","Paulo Coelho", 1990);
        List<Book> books = List.of(book1,book2,book3);
        Library library = new Library();

        assertThat(library.getBooks(), is(equalTo(books)));
    }
}