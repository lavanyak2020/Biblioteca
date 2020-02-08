package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {

    @Test
    public void shouldEquateTwoSameBooksByName() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertThat(book1, is(equalTo(book2)));
    }

    @Test
    public void shouldAvailableWhenBookIsNewlyCreated() {
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertTrue(book.isAvailable());
    }
}
