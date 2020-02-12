package com.twu.biblioteca.bussinesslogic;

public class User {
    private final String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private UserType type;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber, UserType type) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }
}
