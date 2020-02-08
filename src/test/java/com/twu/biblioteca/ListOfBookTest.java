package com.twu.biblioteca;

import UI.AppUI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListOfBookTest {

    @Test
    public void shouldSendListOfBooksFromLibraryToUI() {
        Library library = mock(Library.class);
        AppUI appUI = mock(AppUI.class);
        MenuOption listOfBookOption = new ListOfBook(library, appUI);

        listOfBookOption.execute();

        verify(library, times(1)).getBooks();
    }
}