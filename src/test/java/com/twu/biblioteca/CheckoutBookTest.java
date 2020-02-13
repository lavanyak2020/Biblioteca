package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.execption.ItemDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.ItemIsNotAvailable;
import com.twu.biblioteca.consoleInterface.ConsoleInterface;
import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.menu.items.CheckoutBook;
import com.twu.biblioteca.bussinesslogic.Library;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutBookTest {

    @Test
    public void shouldCheckoutBook() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
        Library library = mock(Library.class);
        ConsoleInterface appUI = mock(ConsoleInterface.class);
        Book book = mock(Book.class);
        when(appUI.getBookFromUser()).thenReturn(book);
        CheckoutBook checkoutBookOption = CheckoutBook.createCheckoutBookOption(library, appUI);

        checkoutBookOption.execute();

        verify(library, times(1)).checkoutItem(book, null);
    }

}
