package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ShowCheckoutMoviesDetailsTest {

    @Test
    public void shouldReturnListOfCheckoutBooksDetails() {
        PresentationInterface presentationInterface = mock(PresentationInterface.class);
        Library library = mock(Library.class);
        ShowCheckoutMoviesDetails showCheckoutMovies = new ShowCheckoutMoviesDetails(library, presentationInterface);

        showCheckoutMovies.execute();

        verify(library, times(1)).getUserCheckOutMovieList();
    }

}