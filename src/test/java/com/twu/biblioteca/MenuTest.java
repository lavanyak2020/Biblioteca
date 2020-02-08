package com.twu.biblioteca;

import UI.AppUI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class MenuTest {

    @Test
    public void shouldReturnListOfOptions() {
        Library library = mock(Library.class);
        AppUI appUI = mock(AppUI.class);
        MenuOption listOfBooks = ListOfBook.createListOfBooksOption(library, appUI);
        Menu menu = new Menu(library, appUI);

        assertThat(menu.getMenuOption(), is(equalTo(List.of(listOfBooks))));
    }
}