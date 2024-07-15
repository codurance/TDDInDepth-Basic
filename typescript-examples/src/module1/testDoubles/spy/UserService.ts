import {EmailSender} from "./EmailSender.ts";

export class UserService {
    private readonly emailSender: EmailSender;

    constructor(emailSender: EmailSender) {
        this.emailSender = emailSender;
    }

    public registerUser(email: string): void {
        // Register user logic
        this.emailSender.sendEmail(email, "Welcome!");
    }
}