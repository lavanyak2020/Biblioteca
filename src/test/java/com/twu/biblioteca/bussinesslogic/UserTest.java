package com.twu.biblioteca.bussinesslogic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    public void shouldReturnDetailsOfUser() {
        UserType.CUSTOMER.setMenuOptions(List.of());
        User user = new User("123-0001",
                "user@1",
                "Lavanya",
                "user1@gmail.com",
                "8096724925", UserType.CUSTOMER);

        assertEquals(user.getName(), "Lavanya");
        assertEquals(user.getEmail(), "user1@gmail.com");
        assertEquals(user.getPhoneNumber(), "8096724925");
        assertEquals(user.getLibraryNumber(), "123-0001");
        assertEquals(user.getPassword(), "user@1");
        assertEquals(user.getType(), UserType.CUSTOMER);
    }
}
