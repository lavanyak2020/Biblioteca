package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.execption.BookDoesNotBelongToLibrary;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotAvailable;
import com.twu.biblioteca.bussinesslogic.execption.BookIsNotCheckout;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LibraryTest {

    @Test
    public void shouldReturnAllBooks() {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist", "Paulo Coelho", 1990);
        List<Book> books = List.of(book1, book2, book3);
        Library library = new Library();

        assertThat(library.getBooks(), is(equalTo(books)));
    }

    @Test
    public void shouldReturnOnlyAvailableBooks() throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
        Library library = new Library();
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist", "Paulo Coelho", 1990);
        List<Book> expectedAvailableBooks = List.of(book2, book3);

        library.checkoutBook(book1);
        assertThat(library.getBooks(), is(equalTo(expectedAvailableBooks)));
    }

    @Test
    public void shouldThrowExceptionWhileCheckoutUnavailableBook() throws BookDoesNotBelongToLibrary, BookIsNotAvailable {
        Library library = new Library();
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        library.checkoutBook(book);

        assertThrows(BookIsNotAvailable.class,() -> library.checkoutBook(book));
    }

    @Test
    public void shouldThrowExceptionWhileReturningInvalidBook() {
        Library library = new Library();
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        assertThrows(BookIsNotCheckout.class,() -> library.returnBook(book));
    }
}