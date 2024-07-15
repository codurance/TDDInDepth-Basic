package com.codurance.module1.TestDoubles.Spy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceShould {
    /**
     * We want to verify that an email is sent when a new user registers.
     */
    @Test
    public void send_welcome_email_after_a_user_creates_an_account() {
        EmailSenderSpy emailSenderSpy = new EmailSenderSpy();
        UserService userService = new UserService(emailSenderSpy);

        userService.registerUser("test@example.com");

        assertTrue(emailSenderSpy.emailSentTo("test@example.com"));
    }
}
