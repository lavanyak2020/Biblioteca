package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.Library;
import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;

public class LoginOption extends MenuOption {

    private final Library library;
    private final PresentationInterface presentationInterface;

    public LoginOption(Library library, PresentationInterface presentationInterface) {
        this.library = library;
        this.presentationInterface = presentationInterface;
        this.name = "Login";
    }

    @Override
    public void execute() {
        String[] loginDetails = presentationInterface.getLoginDetails();
        User user = library.validateUser(loginDetails[0], loginDetails[1]);
        if (user != null) {
            presentationInterface.showSuccessLogin(user);
            return;
        }
        presentationInterface.showUnsuccessLogin();
    }
}
