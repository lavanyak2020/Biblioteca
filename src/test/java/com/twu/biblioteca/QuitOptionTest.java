package com.twu.biblioteca;

import UI.AppUI;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class QuitOptionTest {

    @Test
    public void shouldInvokeQuitApplicationWhenExecuted() {
        AppUI appUI = mock(AppUI.class);
        QuitOption quitOption = QuitOption.createQuitOption(appUI);

        quitOption.execute();

        verify(appUI, times(1)).quitApplication();
    }
}