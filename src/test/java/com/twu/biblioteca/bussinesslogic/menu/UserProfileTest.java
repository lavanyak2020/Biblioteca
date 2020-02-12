package com.twu.biblioteca.bussinesslogic.menu;

import com.twu.biblioteca.bussinesslogic.PresentationInterface;
import com.twu.biblioteca.bussinesslogic.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserProfileTest {

    @Test
    public void shouldSendUserDetails() {
        User user = mock(User.class);
        PresentationInterface presentationInterface = mock(PresentationInterface.class);
        when(presentationInterface.getUser()).thenReturn(user);
        UserProfile userProfile = new UserProfile(presentationInterface);

        userProfile.execute();

        verify(presentationInterface, times(1)).showProfile(user);
    }

}