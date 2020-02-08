package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BookTest {

    @Test
    public void shouldEquateTwoSameBooks() {
        Book book1 = new Book("Quantitative Aptitude");
        Book book2 = new Book("Quantitative Aptitude");

        assertThat(book1, is(equalTo(book2)));
    }

}