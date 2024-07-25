package com.codurance.module1.TestDoublesMockito.Spy;

import com.codurance.module1.TestDoubles.Spy.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceShould {
    /**
     * We want to verify that an email is sent when a new user registers.
     */
    @Test
    public void send_welcome_email_after_a_user_creates_an_account() {
        EmailSenderSpy emailSender = mock(EmailSenderSpy.class);
        UserService userService = new UserService(emailSender);

        userService.registerUser("test@example.com");

        verify(emailSender).sendEmail("test@example.com", "Welcome!");
    }
}
