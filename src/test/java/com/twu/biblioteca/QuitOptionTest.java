package com.twu.biblioteca;

import com.twu.biblioteca.consoleInterface.ConsoleInterface;
import com.twu.biblioteca.bussinesslogic.menu.items.QuitOption;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class QuitOptionTest {

    @Test
    public void shouldInvokeQuitApplicationWhenExecuted() {
        ConsoleInterface appUI = mock(ConsoleInterface.class);
        QuitOption quitOption = QuitOption.createQuitOption(appUI);

        quitOption.execute();

        verify(appUI, times(1)).quitApplication();
    }
}