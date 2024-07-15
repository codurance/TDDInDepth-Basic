package com.codurance.module1.TestDoublesMockito.Mock;

import com.codurance.module1.TestDoubles.Mock.Logger;

import java.util.ArrayList;
import java.util.List;

public class MockLogger implements Logger {
    private final List<String> loggedMessages = new ArrayList<>();
    private final List<String> expectedMessages = new ArrayList<>();

    @Override
    public void log(String message) {
        loggedMessages.add(message);
    }

    // Method to set expected messages
    public void expect(String message) {
        expectedMessages.add(message);
    }

    // Verification method
    public void verify() {
        assertExpectsSize();

        assertLoggedMessages();
    }

    private void assertLoggedMessages() {
        for (int messageIndex = 0; messageIndex < loggedMessages.size(); messageIndex++) {
            if (loggedMessages.get(messageIndex).equals(expectedMessages.get(messageIndex))) {
                continue;
            }

            throwAssertionException(expectedMessages.get(messageIndex), loggedMessages.get(messageIndex));
        }
    }

    private void assertExpectsSize() {
        if (loggedMessages.size() != expectedMessages.size()) {
            throwAssertionException(expectedMessages.size(), loggedMessages.size());
        }
    }

    private void throwAssertionException(int expectedSize, int givenSize) {
        throw new AssertionError(String.format(
            "Expected messages size did not match logged messages size: Expected \"%d\" bu \"%d\" given.",
            expectedSize,
            givenSize
        ));
    }

    private void throwAssertionException(String expectedMessage, String givenMessage) {
        throw new AssertionError(String.format(
                "Expected messages did not match logged messages: Expected \"%s\" but \"%s\" given.",
            expectedMessage,
            givenMessage
        ));
    }
}
