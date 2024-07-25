package com.codurance.module1.TestDoubles.Spy;

import java.util.ArrayList;
import java.util.List;

public class EmailSenderSpy implements EmailSender {
    private List<String> sentEmails = new ArrayList<>();

    @Override
    public void sendEmail(String recipient, String message) {
        sentEmails.add(recipient + ": " + message);
    }

    public boolean emailSentTo(String recipient) {
        return sentEmails.stream().anyMatch(email -> email.startsWith(recipient));
    }
}
