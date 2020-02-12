package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;

public class UserProfile extends MenuOption {

    public UserProfile(PresentationInterface presentationInterface) {
        this.presentationInterface = presentationInterface;
        this.name = "Profile";
    }

    @Override
    public void execute() {
        User user = presentationInterface.getUser();
        presentationInterface.showProfile(user);
    }
}
