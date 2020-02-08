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
        when(appUI.getBookNameFromUser()).thenReturn("Quantitative aptitude");
        ReturnBook returnBookOption = ReturnBook.createReturnBookOption(library, appUI);

        returnBookOption.execute();

        verify(library, times(1)).returnBook("Quantitative aptitude");
    }
}