package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.menu.items.ShowCheckoutBookDetails;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ShowCheckoutBookDetailsTest {

    @Test
    public void shouldReturnListOfCheckoutBooksDetails() {
        PresentationInterface presentationInterface = mock(PresentationInterface.class);
        Library library = mock(Library.class);
        ShowCheckoutBookDetails showCheckoutBookDetails = new ShowCheckoutBookDetails(library, presentationInterface);

        showCheckoutBookDetails.execute();

        verify(library, times(1)).getUserCheckOutItemList();
    }
}
