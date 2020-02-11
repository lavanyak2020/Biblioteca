package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotAvailable;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;
import com.twu.biblioteca.consoleInterface.ConsoleInterface;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.menu.MenuOption;
import org.junit.jupiter.api.Test;

import static com.twu.biblioteca.bussinesslogic.menu.ListOfBook.*;
import static org.mockito.Mockito.*;

class ListOfBookTest {

    @Test
    public void shouldSendListOfBooksFromLibraryToUI() throws BookIsNotAvailable, BookIsNotCheckout, BookDoesNotBelongToLibrary {
        Library library = mock(Library.class);
        ConsoleInterface appUI = mock(ConsoleInterface.class);
        MenuOption listOfBookOption = createListOfBooksOption(library,appUI);

        listOfBookOption.execute();

        verify(library, times(1)).getBooks();
    }
}