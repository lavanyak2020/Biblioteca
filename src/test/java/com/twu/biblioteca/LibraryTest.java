package com.twu.biblioteca;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Library;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

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
    public void shouldReturnOnlyAvailableBooks() {
        Library library = new Library();
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Head First Java", "Bert Bates, Kathy Sierra", 2005);
        Book book3 = new Book("Alchemist", "Paulo Coelho", 1990);
        List<Book> expectedAvailableBooks = List.of(book2, book3);

        library.checkoutBook(book1);
        assertThat(library.getBooks(), is(equalTo(expectedAvailableBooks)));
    }

    @Test
    public void shouldReturnSuccessMessageIfBookIsCheckoutSuccessfully() {
        Library library = new Library();
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        String actualMessage = library.checkoutBook(book);

        assertThat(actualMessage, is(equalTo("Thank you! Enjoy the book")));
    }

    @Test
    public void shouldReturnUnsuccessMessageWhileCheckoutUnavailableBook() {
        Library library = new Library();
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        library.checkoutBook(book);

        String actualMessage = library.checkoutBook(book);

        assertThat(actualMessage, is(equalTo("Sorry, that book is not available")));
    }

    @Test
    public void shouldReturnSuccessMessageIfBookIsReturnedSuccessfully() {
        Library library = new Library();
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        library.checkoutBook(book);

        String actualMessage = library.returnBook(book);

        assertThat(actualMessage, is(equalTo("Thank you for returning the book")));
    }

    @Test
    public void shouldReturnUnsuccessMessageWhileReturningInvalidBook() {
        Library library = new Library();
        Book book = new Book("Quantitative Aptitude", "RS Agarwal", 2008);

        String actualMessage = library.returnBook(book);

        assertThat(actualMessage, is(equalTo("That is not a valid book to return.")));
    }
}