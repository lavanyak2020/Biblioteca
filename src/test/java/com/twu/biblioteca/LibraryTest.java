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
        List<User> users;

        @BeforeEach
        public void setUp() {
            Book book1 = mock(Book.class);
            Book book2 = mock(Book.class);
            Book book3 = mock(Book.class);
            books = List.of(book1, book2, book3);
            movies = List.of();
            users = List.of();
        }

        @Test
        public void shouldReturnAllBooks() {
            Library library = new Library(books, movies, users);

            assertThat(library.getAvailableItems(), is(equalTo(books)));
        }

        @Test
        public void shouldReturnOnlyAvailableBooks() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
            Library library = new Library(books, movies, users);

            library.checkoutItem(books.get(0), null);

            assertThat(library.getAvailableItems(), is(equalTo(List.of(books.get(1), books.get(2)))));
        }

        @Test
        public void shouldThrowExceptionWhileCheckoutUnavailableBook() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
            Library library = new Library(books, movies, users);
            library.checkoutItem(books.get(0), null);

            assertThrows(ItemIsNotAvailable.class, () -> library.checkoutItem(books.get(0), null));
        }

        @Test
        public void shouldThrowExceptionWhileReturningInvalidBook() {
            Library library = new Library(books, movies, users);

            assertThrows(ItemIsNotCheckout.class, () -> library.returnItem(books.get(0), null));
        }
    }

    @Nested
    class MovieTests {
        List<Book> books;
        List<Movie> movies;
        List<User> users;

        @BeforeEach
        public void setUp() {
            books = List.of();
            users = List.of();
            Movie movie1 = mock(Movie.class);
            Movie movie2 = mock(Movie.class);
            Movie movie3 = mock(Movie.class);
            movies = List.of(movie1, movie2, movie3);
        }

        @Test
        public void shouldReturnListOfAvailableMovies() {
            Library library = new Library(books, movies, users);

            assertEquals(library.getAvailableItems(), movies);
        }

        @Test
        public void shouldCheckoutMovieIfItIsAvailable() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
            Library library = new Library(books, movies, users);
            Movie movieForCheckout = movies.get(0);

            library.checkoutItem(movieForCheckout, null);

            assertEquals(library.getAvailableItems(), List.of(movies.get(1), movies.get(2)));
        }

        @Test
        public void shouldThrowExceptionWhileCheckoutingUnavailableBook() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
            Library library = new Library(books, movies, users);
            Movie movieForCheckout = movies.get(0);
            library.checkoutItem(movieForCheckout, null);

            assertThrows(ItemIsNotAvailable.class, () -> library.checkoutItem(movieForCheckout, null));
        }

        @Test
        public void shouldThrowExceptionWhileCheckoutingInvalidBookThatDoesNotBelongLibrary() {
            Library library = new Library(books, movies, users);
            Movie movieForCheckout = mock(Movie.class);

            assertThrows(ItemDoesNotBelongToLibrary.class, () -> library.checkoutItem(movieForCheckout, null));
        }

        @Test
        public void shouldReturnMovieIfItIsCheckout() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable, ItemIsNotCheckout {
            Library library = new Library(books, movies, users);
            Movie movieForCheckout = movies.get(0);
            library.checkoutItem(movieForCheckout, null);

            library.returnItem(movieForCheckout, null);

            assertEquals(library.getAvailableItems(), List.of(movies.get(1), movies.get(2), movies.get(0)));
        }

        @Test
        public void shouldThrowExceptionWhileReturningUnCheckoutBook() {
            Library library = new Library(books, movies, users);
            Movie movieForCheckout = movies.get(0);

            assertThrows(ItemIsNotCheckout.class, () -> library.returnItem(movieForCheckout, null));
        }
    }

    @Nested
    class UserTests {
        private List<Book> books;
        private List<Movie> movies;
        List<User> users;

        @BeforeEach
        public void setUp() {
            Book book1 = mock(Book.class);
            Book book2 = mock(Book.class);
            Book book3 = mock(Book.class);
            books = List.of(book1, book2, book3);
            movies = List.of();
            users = List.of();
        }

        @Test
        public void shouldAddUserAndCheckoutBookWhileCheckout() throws ItemDoesNotBelongToLibrary, ItemIsNotAvailable {
            Library library = new Library(books, movies, users);
            User user = mock(User.class);
            HashMap<Book, User> expectedBookCheckOutList = new HashMap<>();
            expectedBookCheckOutList.put(books.get(0), user);

            library.checkoutItem(books.get(0), user);

            assertEquals(library.getUserCheckOutItemList(), expectedBookCheckOutList);
        }
    }
}
