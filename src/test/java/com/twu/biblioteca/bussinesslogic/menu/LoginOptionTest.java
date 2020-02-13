package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import com.twu.biblioteca.bussinesslogic.menu.items.LoginOption;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class LoginOptionTest {

    @Test
    public void shouldAllowValidUserToLogin() {
        User user = mock(User.class);
        when(user.getLibraryNumber()).thenReturn("123-0001");
        when(user.getPassword()).thenReturn("1234");
        PresentationInterface presentationInterface = mock(PresentationInterface.class);
        when(presentationInterface.getLoginDetails()).thenReturn(new String[]{"123-0001", "1234"});
        LoginOption loginOption = new LoginOption(List.of(user), presentationInterface);

        loginOption.execute();

        verify(presentationInterface, times(1)).showSuccessLogin(user);
    }

}