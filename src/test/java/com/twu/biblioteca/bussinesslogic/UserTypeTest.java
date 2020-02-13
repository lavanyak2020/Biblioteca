package com.twu.biblioteca.bussinesslogic;

import com.twu.biblioteca.bussinesslogic.menu.items.ListBooks;
import com.twu.biblioteca.bussinesslogic.menu.items.MenuOption;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserTypeTest {

    @Test
    public void shouldReturnMenuOptionsOfLibrarian() {
        MenuOption menuOption = mock(ListBooks.class);
        UserType.LIBRARIAN.setMenuOptions(List.of(menuOption));

        assertEquals(UserType.LIBRARIAN.getMenuOption(), List.of(menuOption));
    }
}
