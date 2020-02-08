import UI.AppUI;
import com.twu.biblioteca.Biblioteca;

public class BibliotecaApp {
    private Biblioteca biblioteca;
    private AppUI appUI;

    public static void main(String[] args) {
        new BibliotecaApp().start();
    }

    private void start() {
        appUI = new AppUI();
        biblioteca = new Biblioteca(appUI);
        appUI.displayWelcomeMessage(biblioteca.getWelcomeMessage());
        appUI.displayMenu(biblioteca.getMenuItems());
        int userInput = appUI.getUserInput();
    }
}
