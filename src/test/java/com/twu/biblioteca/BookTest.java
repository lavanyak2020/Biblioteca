package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BookTest {

    @Test
    public void shouldEquateTwoSameBooksByNameAndAuthorAndYearOfPublication() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertThat(book1, is(equalTo(book2)));
    }

    @Test
    public void shouldReturnNameOfBook() {
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertThat(book.getName(), is(equalTo("Quantitative Aptitude")));
    }

    @Test
    public void shouldReturnAuthorNameOfBook() {
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertThat(book.getAuthor(), is(equalTo("RS Agarwal")));
    }

    @Test
    public void shouldReturnPublishedYearOfBook() {
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertThat(book.getPublicationYear(), is(equalTo(2008)));
    }
}
