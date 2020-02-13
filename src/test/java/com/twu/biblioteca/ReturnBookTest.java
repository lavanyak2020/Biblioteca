package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.execption.ItemDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.ItemIsNotCheckout;
import com.twu.biblioteca.consoleInterface.ConsoleInterface;
import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.menu.items.ReturnBook;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReturnBookTest {

    @Test
    public void shouldReturnBook() throws ItemDoesNotBelongToLibrary, ItemIsNotCheckout {
        Library library = mock(Library.class);
        ConsoleInterface appUI = mock(ConsoleInterface.class);
        Book book = mock(Book.class);
        when(appUI.getBookFromUser()).thenReturn(book);
        ReturnBook returnBookOption = ReturnBook.createReturnBookOption(library, appUI);

        returnBookOption.execute();

        verify(library, times(1)).returnItem(book, null);
    }
}