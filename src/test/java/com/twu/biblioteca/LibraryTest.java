package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.execption.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class LibraryTest {

    @Nested
    class BooksTest {
        List<Book> books;
        List<Movie> movies;

        @BeforeEach
        public void setUp() {
            Book book1 = mock(Book.class);
            Book book2 = mock(Book.class);
            Book book3 = mock(Book.class);
            books = List.of(book1, book2, book3);
            movies = List.of();
        }

        @Test
        public void shouldReturnAllBooks() {
            Library library = new Library(books, movies);

            assertThat(library.getAvailableBooks(), is(equalTo(books)));
        }

        @Test
        public void shouldReturnOnlyAvailableBooks() throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
            Library library = new Library(books, movies);

            library.checkoutBook(books.get(0), null);

            assertThat(library.getAvailableBooks(), is(equalTo(List.of(books.get(1), books.get(2)))));
        }

        @Test
        public void shouldThrowExceptionWhileCheckoutUnavailableBook() throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
            Library library = new Library(books, movies);
            library.checkoutBook(books.get(0), null);

            assertThrows(BookIsNotAvailable.class, () -> library.checkoutBook(books.get(0), null));
        }

        @Test
        public void shouldThrowExceptionWhileReturningInvalidBook() {
            Library library = new Library(books, movies);

            assertThrows(BookIsNotCheckout.class, () -> library.returnBook(books.get(0), null));
        }
    }

    @Nested
    class MovieTests {
        List<Book> books;
        List<Movie> movies;

        @BeforeEach
        public void setUp() {
            books = List.of();
            Movie movie1 = mock(Movie.class);
            Movie movie2 = mock(Movie.class);
            Movie movie3 = mock(Movie.class);
            movies = List.of(movie1, movie2, movie3);
        }

        @Test
        public void shouldReturnListOfAvailableMovies() {
            Library library = new Library(books, movies);

            assertEquals(library.getAvailableMovies(), movies);
        }

        @Test
        public void shouldCheckoutMovieIfItIsAvailable() throws MovieIsNotAvailable, MovieDoesNotBelongToLibrary {
            Library library = new Library(books, movies);
            Movie movieForCheckout = movies.get(0);

            library.checkoutMovie(movieForCheckout, null);

            assertEquals(library.getAvailableMovies(), List.of(movies.get(1), movies.get(2)));
        }

        @Test
        public void shouldThrowExceptionWhileCheckoutingUnavailableBook() throws MovieIsNotAvailable, MovieDoesNotBelongToLibrary {
            Library library = new Library(books, movies);
            Movie movieForCheckout = movies.get(0);
            library.checkoutMovie(movieForCheckout, null);

            assertThrows(MovieIsNotAvailable.class, () -> library.checkoutMovie(movieForCheckout, null));
        }

        @Test
        public void shouldThrowExceptionWhileCheckoutingInvalidBookThatDoesNotBelongLibrary() {
            Library library = new Library(books, movies);
            Movie movieForCheckout = mock(Movie.class);

            assertThrows(MovieDoesNotBelongToLibrary.class, () -> library.checkoutMovie(movieForCheckout, null));
        }

        @Test
        public void shouldReturnMovieIfItIsCheckout() throws MovieIsNotAvailable, MovieDoesNotBelongToLibrary, MovieIsNotCheckout {
            Library library = new Library(books, movies);
            Movie movieForCheckout = movies.get(0);
            library.checkoutMovie(movieForCheckout, null);

            library.returnMovie(movieForCheckout, null);

            assertEquals(library.getAvailableMovies(), List.of(movies.get(1), movies.get(2), movies.get(0)));
        }

        @Test
        public void shouldThrowExceptionWhileReturningUnCheckoutBook() {
            Library library = new Library(books, movies);
            Movie movieForCheckout = movies.get(0);

            assertThrows(MovieIsNotCheckout.class, () -> library.returnMovie(movieForCheckout, null));
        }
    }

    @Nested
    class UserTests {

        private List<Book> books;
        private List<Movie> movies;

        @BeforeEach
        public void setUp() {
            Book book1 = mock(Book.class);
            Book book2 = mock(Book.class);
            Book book3 = mock(Book.class);
            books = List.of(book1, book2, book3);
            movies = List.of();
        }
        @Test
        public void shouldAddUserAndCheckoutBookWhileCheckout() throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
            Library library = new Library(books, movies);
            User user = mock(User.class);
            HashMap<Book, User> expectedBookCheckOutList = new HashMap<>();
            expectedBookCheckOutList.put(books.get(0), user);

            library.checkoutBook(books.get(0), user);

            assertEquals(library.getUserCheckOutBookList(), expectedBookCheckOutList);
        }
    }
}
