package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.*;
import com.twu.biblioteca.bussinesslogic.execption.*;
import com.twu.biblioteca.bussinesslogic.menu.CheckoutMovie;
import com.twu.biblioteca.bussinesslogic.menu.MenuOption;

import java.util.*;

import static com.twu.biblioteca.consoleInterface.Message.*;

public class ConsoleInterface implements PresentationInterface {
    private final List<Book> books;
    private final List<Movie> movies;
    private User currentUser;

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
        } catch (ItemDoesNotBelongToLibrary itemDoesNotBelongToLibrary) {
            itemDoesNotBelongToLibrary.printStackTrace();
        } catch (ItemIsNotAvailable itemIsNotAvailable) {
            if(selectedOption.getClass() == CheckoutMovie.class)
                displayMessage(CHECKOUT_MOVIE_UNSUCCESS_MESSAGE);
            else
                displayMessage(CHECKOUT_UNSUCCESS_MESSAGE);
        } catch (ItemIsNotCheckout itemIsNotCheckout) {
            if(selectedOption.getClass() == CheckoutMovie.class)
                displayMessage(RETURN_MOVIE_UNSUCCESS_MESSAGE);
            else
                displayMessage(RETURN_UNSUCCESS_MESSAGE);
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
    public void listOfBooks(List<LibraryItem> items) {
        System.out.println("--------------------------------------------------------------------");
        for (LibraryItem item : items) {
            if(item.getClass() == Book.class) {
                Book book = (Book) item;
                System.out.println(book.getName() + "\t\t" + book.getAuthor() + "\t\t" + book.getPublicationYear());
                System.out.println("--------------------------------------------------------------------");
            }
        }
    }

    @Override
    public void listOfMovies(List<LibraryItem> items) {
        System.out.println("--------------------------------------------------------------------");
        for (LibraryItem item : items) {
            if( item.getClass() == Movie.class) {
                Movie movie = (Movie) item;
                System.out.println(movie.getName() + "\t\t" + movie.getDirectorName() + "\t\t" + movie.getReleaseYear() + "\t\t" + movie.getRating());
                System.out.println("--------------------------------------------------------------------");
            }
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

    @Override
    public String[] getLoginDetails() {
        String[] loginDetails = new String[2];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Library number:");
        loginDetails[0] = scan.next();
        System.out.println("Enter password:");
        loginDetails[1] = scan.next();
        return loginDetails;
    }

    @Override
    public void showSuccessLogin(User user) {
        System.out.println("Login Successfully");
        currentUser = user;
    }

    @Override
    public void showUnsuccessLogin() {
        System.out.println("Invalid Library number and password");
    }

    @Override
    public void showCheckoutBooksList(HashMap<LibraryItem, User> userCheckOutBookList) {
        Set<LibraryItem> items = userCheckOutBookList.keySet();

        for (LibraryItem item : items) {
            if(item.getClass() == Book.class){
                Book book = (Book) item;
                User user = userCheckOutBookList.get(book);
                System.out.println(book.getName() + "\t\t" + user.getName());
            }
        }
    }

    @Override
    public User getUser() {
        return currentUser;
    }

    @Override
    public void showCheckoutMoviesList(HashMap<LibraryItem, User> userCheckOutMovieList) {
        Set<LibraryItem> items = userCheckOutMovieList.keySet();

        for (LibraryItem item : items) {
            if(item.getClass() == Movie.class){
                Movie movie = (Movie) item;
                User user = userCheckOutMovieList.get(movie);
                System.out.println(movie.getName() + "\t\t" + user.getName());
            }
        }
    }

    @Override
    public void showSuccessLogOut() {
        currentUser = null;
        System.out.println("...............Logout...........");
    }

    @Override
    public void showProfile(User user) {
        System.out.println("Library number : "+user.getLibraryNumber());
        System.out.println("Name : "+user.getName());
        System.out.println("email : "+user.getEmail());
        System.out.println("Phone number : "+user.getPhoneNumber());
    }

    private Movie getMovieByName(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }

    private Book getBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }
}
