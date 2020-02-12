package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotAvailable;
import com.twu.biblioteca.consoleInterface.ConsoleInterface;
import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.menu.CheckoutBook;
import com.twu.biblioteca.bussinesslogic.Library;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutBookTest {

    @Test
    public void shouldCheckoutBook() throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
        Library library = mock(Library.class);
        ConsoleInterface appUI = mock(ConsoleInterface.class);
        Book book = mock(Book.class);
        when(appUI.getBookFromUser()).thenReturn(book);
        CheckoutBook checkoutBookOption = CheckoutBook.createCheckoutBookOption(library, appUI);

        checkoutBookOption.execute();

        verify(library, times(1)).checkoutBook(book, null);
    }

}
