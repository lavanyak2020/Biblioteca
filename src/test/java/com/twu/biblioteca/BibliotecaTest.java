package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class BibliotecaTest {

    @Test
    public void shouldGreetWithWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();

        assertThat(biblioteca.getWelcomeMessage(), is(equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!")));
    }
}
