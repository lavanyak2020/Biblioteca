package com.twu.biblioteca.bussinesslogic.menu.menulist;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.menu.items.*;

import java.util.List;

public class DefaultMenuList {
    private final List<MenuOption> menuOptions;

    public DefaultMenuList(Library library, List<User> users, PresentationInterface presentationInterface) {
        menuOptions = List.of(
                ListBooks.createListOfBooksOption(library, presentationInterface),
                new ListMovies(library, presentationInterface),
                new LoginOption(users, presentationInterface),
                QuitOption.createQuitOption(presentationInterface)
        );
    }

    public List<MenuOption> getMenuOptions() {
        return menuOptions;
    }
}
