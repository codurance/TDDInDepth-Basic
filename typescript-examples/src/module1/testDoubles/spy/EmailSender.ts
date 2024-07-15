export interface EmailSender {
    sendEmail(email: string, message: string): void
}

