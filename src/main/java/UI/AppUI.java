package UI;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.MenuOption;

import java.util.List;
import java.util.Scanner;

public class AppUI {

    public void displayWelcomeMessage(String message) {
        System.out.println(message);
    }

    public void displayListOfBooks(List<Book> books) {
        System.out.println("--------------------------------------------------------------------");
        for (Book book : books) {
            System.out.println(book.getName() + "\t\t" + book.getAuthor() + "\t\t" + book.getPublicationYear());
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public void displayMenu(List<MenuOption> menuItems) {
        int i = 1;
        for (MenuOption option : menuItems) {
            System.out.println(i + " . " + option.getName());
            i++;
        }
    }

    public int getUserInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your option number:");
        return scan.nextInt();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void quitApplication() {
        System.exit(0);
    }
}
