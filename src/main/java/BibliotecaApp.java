import UI.AppUI;
import com.twu.biblioteca.Biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        AppUI appUI = new AppUI();
        Biblioteca biblioteca = new Biblioteca(appUI);
        appUI.displayMessage(biblioteca.getWelcomeMessage());
        do {
            appUI.displayMenu(biblioteca.getMenuItems());
            int userInput = appUI.getUserInput();
            biblioteca.execute(userInput - 1);
        } while (true);
    }
}
