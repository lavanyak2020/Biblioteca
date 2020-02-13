package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ListMoviesTest {

    @Test
    public void shouldTakeListOfAvailableMoviesFromLibrary() {
        Library library = mock(Library.class);
        PresentationInterface presentationInterface = mock(PresentationInterface.class);
        ListMovies listMovies = new ListMovies(library, presentationInterface);

        listMovies.execute();

        verify(library, times(1)).getAvailableItems();
    }
}