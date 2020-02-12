package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.Movie;
import com.twu.biblioteca.bussinesslogic.execption.*;
import com.twu.biblioteca.bussinesslogic.menu.MenuOption;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

import java.util.List;
import java.util.Scanner;

import static com.twu.biblioteca.consoleInterface.Message.*;

public class ConsoleInterface implements PresentationInterface {
    private List<Book> books;
    private List<Movie> movies;

    public ConsoleInterface(List<Book> books, List<Movie> movies) {
        this.books = books;
        this.movies = movies;
    }

    public void displayMenu(List<MenuOption> menuItems) {
        int i = 1;
        System.out.println("\n\n*-------------------------------* Menu *-------------------------------*");
        for (MenuOption option : menuItems) {
            System.out.println("\t\t" + i + " . " + option.getName());
            i++;
        }
    }

    public int getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your option number:");
        return scan.nextInt();
    }

    public void executeOption(int optionIndex, List<MenuOption> menuOptions) {
        if (optionIndex < 0 || optionIndex >= menuOptions.size()) {
            displayMessage("Invalid Option");
            return;
        }
        MenuOption selectedOption = menuOptions.get(optionIndex);
        try {
            selectedOption.execute();
        } catch (BookDoesNotBelongToLibrary bookDoesNotBelongToLibrary) {
            bookDoesNotBelongToLibrary.printStackTrace();
        } catch (BookIsNotAvailable bookIsNotAvailable) {
            displayMessage(CHECKOUT_UNSUCCESS_MESSAGE);
        } catch (BookIsNotCheckout bookIsNotCheckout) {
            displayMessage(RETURN_UNSUCCESS_MESSAGE);
        } catch (MovieDoesNotBelongToLibrary movieDoesNotBelongToLibrary) {
            movieDoesNotBelongToLibrary.printStackTrace();
        } catch (MovieIsNotAvailable movieIsNotAvailable) {
            displayMessage(CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);
        } catch (MovieIsNotCheckout movieIsNotCheckout) {
            displayMessage(RETURN_MOVIE_UNSUCCESS_MESSAGE);
        }
    }

    public void displayMessage(String message) {
        System.out.println("\t**********************\t" + message + "\t**********************\t");
    }

    @Override
    public void quitApplication() {
        System.out.println("\t..................(^.^) Bye.. Bye... Bye....... ...................:D");
        System.exit(0);
    }

    @Override
    public void listOfBooks(List<Book> books) {
        System.out.println("--------------------------------------------------------------------");
        for (Book book : books) {
            System.out.println(book.getName() + "\t\t" + book.getAuthor() + "\t\t" + book.getPublicationYear());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    @Override
    public void listOfMovies(List<Movie> movies) {
        System.out.println("--------------------------------------------------------------------");
        for (Movie movie : movies) {
            System.out.println(movie.getName() + "\t\t" + movie.getDirectorName() + "\t\t" + movie.getReleaseYear() + "\t\t" + movie.getRating());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    @Override
    public Book getBookFromUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Book name:");
        String bookName = scan.nextLine();

        return getBookByName(bookName);
    }

    @Override
    public Movie getMovieFromUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Movie name:");
        String bookName = scan.nextLine();

        return getMovieByName(bookName);
    }

    @Override
    public void showCheckoutSuccess() {
        displayMessage(CHECKOUT_SUCCESS_MESSAGE);
    }

    @Override
    public void showMovieCheckoutSuccess() {
        displayMessage(CHECKOUT_MOVIE_SUCCESS_MESSAGE);
    }

    @Override
    public void showReturnSuccess() {
        displayMessage(RETURN_SUCCESS_MESSAGE);
    }

    @Override
    public void showMovieReturnSuccess() {
        displayMessage(RETURN_MOVIE_SUCCESS_MESSAGE);
    }

    private Movie getMovieByName(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    private Book getBookByName(String bookName) {
        for (Book book : books) {
            System.out.println(book.getName());
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }
}
