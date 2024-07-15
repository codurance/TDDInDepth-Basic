import {EmailSender} from "../EmailSender.ts";

export class EmailSenderSpy implements EmailSender {
    private sentEmails: Map<string, string> = new Map<string, string>()


    sendEmail(email: string, message: string): void {
        this.sentEmails.set(email, message);
    }

    emailSentTo(email: string) {
        return this.sentEmails.has(email);
    }
}