package com.twu.biblioteca;

import UI.AppUI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CheckoutBookTest {

    @Test
    public void shouldCheckoutBook() {
        Library library = mock(Library.class);
        AppUI appUI = mock(AppUI.class);
        Book book = mock(Book.class);
        when(appUI.getBookFromUser()).thenReturn(book);
        CheckoutBook checkoutBookOption = CheckoutBook.createCheckoutBookOption(library, appUI);

        checkoutBookOption.execute();

        verify(library, times(1)).checkoutBook(book);
    }

}
