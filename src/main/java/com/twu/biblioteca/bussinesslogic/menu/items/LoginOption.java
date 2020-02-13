package com.twu.biblioteca.bussinesslogic.menu.items;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;

import java.util.List;

public class LoginOption extends MenuOption {

    private final List<User> users;
    private final PresentationInterface presentationInterface;

    public LoginOption(List<User> users, PresentationInterface presentationInterface) {
        this.users = users;
        this.presentationInterface = presentationInterface;
        this.name = "Login";
    }

    @Override
    public void execute() {
        String[] loginDetails = presentationInterface.getLoginDetails();
        User user = getUserByLoginDetails(loginDetails);
        if(user != null){
            presentationInterface.showSuccessLogin(user);
            return;
        }
        presentationInterface.showUnsuccessLogin();
    }

    private User getUserByLoginDetails(String[] loginDetails) {
        for (User user : users) {
            if ((user.getLibraryNumber().equals(loginDetails[0])) && (user.getPassword().equals(loginDetails[1])))
                return user;
        }
        return null;
    }
}
