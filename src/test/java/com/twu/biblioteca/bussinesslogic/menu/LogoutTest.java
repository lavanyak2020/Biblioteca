package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.menu.items.Logout;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LogoutTest {

    @Test
    public void shouldUserCanLogout() {
        PresentationInterface presentationInterface = mock(PresentationInterface.class);
        User user = mock(User.class);
        when(presentationInterface.getUser()).thenReturn(user);
        Logout logout = new Logout(presentationInterface);

        logout.execute();

        verify(presentationInterface, times(1)).showSuccessLogOut();
    }
}