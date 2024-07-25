package com.codurance.module1.TestDoubles.Spy;

public class UserService {
    private EmailSender emailSender;

    public UserService(EmailSender emailService) {
        this.emailSender = emailService;
    }

    public void registerUser(String email) {
        // Register user logic
        emailSender.sendEmail(email, "Welcome!");
    }
}
