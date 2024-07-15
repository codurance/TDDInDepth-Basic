import {describe, expect, it} from "vitest";
import {UserService} from "../UserService.ts";
import {EmailSenderSpy} from "../__mocks__/EmailSenderSpy.ts";

describe("UserService", () => {
    it("should send welcome email after a user creates an account", () => {
        const emailSenderSpy = new EmailSenderSpy();
        const userService = new UserService(emailSenderSpy);
        let email = "test@example.com";

        userService.registerUser(email);

        expect(emailSenderSpy.emailSentTo(email)).toBe(true)
    })
})