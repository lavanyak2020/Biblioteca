package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;

public class Logout extends MenuOption {
    private final PresentationInterface presentationInterface;

    public Logout(PresentationInterface presentationInterface) {
        this.presentationInterface = presentationInterface;
        this.name = "Logout";
    }

    @Override
    public void execute() {
        User user = presentationInterface.getUser();
        if (user != null) {
            presentationInterface.showSuccessLogOut();
        }
    }
}
