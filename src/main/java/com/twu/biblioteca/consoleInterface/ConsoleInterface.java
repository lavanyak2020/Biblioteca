package com.twu.biblioteca.consoleInterface;

import com.twu.biblioteca.bussinesslogic.Book;
import com.twu.biblioteca.bussinesslogic.menu.MenuOption;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface implements PresentationInterface {
    List<Book> books;

    public ConsoleInterface(List<Book> books) {
        this.books = books;
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
    public void message(String message) {
        System.out.println("\t**********************\t" + message + "\t**********************\t");
    }

    @Override
    public Book getBookFromUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Book name:");
        String bookName = scan.nextLine();

        return getBookByName(bookName);
    }

    private Book getBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }
}
