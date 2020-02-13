package com.twu.biblioteca.datalayer;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Movie;
import com.twu.biblioteca.bussinesslogic.User;

import java.util.List;

import static com.twu.biblioteca.bussinesslogic.UserType.CUSTOMER;
import static com.twu.biblioteca.bussinesslogic.UserType.LIBRARIAN;

public class Data {
    private static final List<Book> books;

    private static final List<Movie> movies;

    private static final List<User> users;

    private Data() {
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public static List<User> getUsers() {
        return users;
    }

    static {
        Book book1 = new Book("Quantitative Aptitude", "RS Agarwal", 2008);
        Book book2 = new Book("Beauty", " Sheri S. Tepper", 1991);
        Book book3 = new Book("Alphabet of Thorn", "Patricia McKillip", 2004);
        books = List.of(book1, book2, book3);
        Movie movie1 = new Movie("Ala Vaikunta Puramlo", "Trivikram Srinivas", 2020, 10);
        Movie movie2 = new Movie("Sarileru Neekevaru", "Anil Ravipudi", 2020, 5);
        Movie movie3 = new Movie("Jaanu", "Prem Kumar", 2020, 8);
        movies = List.of(movie1, movie2, movie3);
        User user = new User("123-0001", "1234", "lavanya", "lavanya@gmail.com", "8096724925", CUSTOMER);
        User librarian = new User("123-0002", "librarian", "Librarian", "lavanya@gmail.com", "8096724925", LIBRARIAN);
        users = List.of(user, librarian);
    }
}
