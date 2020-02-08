import com.twu.biblioteca.Book;

import java.util.List;

public class AppUI {

    public void displayWelcomeMessage(String message) {
        System.out.println(message);
    }

    public void displayListOfBooks(List<Book> books) {
        System.out.println("--------------------------------------------------------------------");
        for(Book book : books){
            System.out.println(book.getName()+"\t\t"+book.getAuthor()+"\t\t"+book.getPublicationYear());
            System.out.println("--------------------------------------------------------------------");
        }
    }
}
