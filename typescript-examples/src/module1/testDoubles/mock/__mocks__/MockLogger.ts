import {Logger} from "../Logger.ts";

class AssertionError extends Error {
}

export class MockLogger implements Logger {
    private readonly loggedMessages: string[] = [];
    private readonly expectedMessages: string[] = [];

    public log(message: string): void {
        this.loggedMessages.push(message);
    }

    public expect(message: string) {
        this.expectedMessages.push(message);
    }

    public verify(): void {
        this.assertExpectsSize();

        this.assertLoggedMessages();
    }

    private assertExpectsSize() {
        if (this.loggedMessages.length !== this.expectedMessages.length) {
            this.throwMessageSizeMismatchError(this.expectedMessages.length, this.loggedMessages.length);
        }
    }

    private throwMessageSizeMismatchError(expectedSize: number, givenSize: number) {
        throw new AssertionError(`Expected messages size did not match logged messages size: Expected ${expectedSize} but given ${givenSize}`)
    }

    private throwMessageMismatchError(expectedMessage: string, givenMessage: string) {
        throw new AssertionError(`Expected messages did not match logged messages: Expected ${expectedMessage} but given ${givenMessage}`)
    }

    private assertLoggedMessages() {
        for (let messageIndex = 0; messageIndex < this.loggedMessages.length; messageIndex++) {
            if (this.loggedMessages[messageIndex] !== this.expectedMessages[messageIndex]) {
                this.throwMessageMismatchError(this.expectedMessages[messageIndex], this.loggedMessages[messageIndex])
            }
        }
    }
}