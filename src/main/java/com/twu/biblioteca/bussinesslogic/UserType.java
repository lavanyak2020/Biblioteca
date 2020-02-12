package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.menu.MenuOption;

import java.util.List;

public class UserType {
    public static final UserType LIBRARIAN = new UserType();
    public static final UserType CUSTOMER = new UserType();
    private List<MenuOption> menuOption;

    private UserType() {

    }
    public void setMenuOptions(List<MenuOption> menuOptions){
        this.menuOption = menuOptions;
    }

    public List<MenuOption> getMenuOption() {
        return menuOption;
    }
}
