import { describe, expect, it, vi } from "vitest";
import { EmailSender } from "../EmailSender.ts";
import { UserService } from "../UserService.ts";

describe("UserService", () => {
    it("should send welcome email after a user creates an account", () => {
        const emailSender: EmailSender = {
            sendEmail: vi.fn(),
        };
        const userService = new UserService(emailSender);
        const email = "test@example.com";

        userService.registerUser(email);

        expect(emailSender.sendEmail).toHaveBeenCalledWith(email, "Welcome!");
    });
});
