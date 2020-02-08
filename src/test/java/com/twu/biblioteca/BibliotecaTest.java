package com.twu.biblioteca;

import UI.AppUI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

class BibliotecaTest {

    @Test
    public void shouldGreetWithWelcomeMessage() {
        AppUI appUI = mock(AppUI.class);
        Biblioteca biblioteca = new Biblioteca(appUI);

        assertThat(biblioteca.getWelcomeMessage(), is(equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!")));
    }

    @Test
    public void shouldReturnMenuItems() {
        AppUI appUI = mock(AppUI.class);
        Library library = mock(Library.class);
        MenuOption menuOption = ListOfBook.createListOfBooksOption(library, appUI);
        Biblioteca biblioteca = new Biblioteca(appUI);

        assertThat(biblioteca.getMenuItems(), is(equalTo(List.of(menuOption))));
    }
}
