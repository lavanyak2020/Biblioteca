package com.twu.biblioteca;

import UI.AppUI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReturnBookTest {

    @Test
    public void shouldReturnBook() {
        Library library = mock(Library.class);
        AppUI appUI = mock(AppUI.class);
        Book book = mock(Book.class);
        when(appUI.getBookFromUser()).thenReturn(book);
        ReturnBook returnBookOption = ReturnBook.createReturnBookOption(library, appUI);

        returnBookOption.execute();

        verify(library, times(1)).returnBook(book);
    }
}