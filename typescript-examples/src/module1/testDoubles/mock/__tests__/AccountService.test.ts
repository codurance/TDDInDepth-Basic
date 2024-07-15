import {describe, it} from "vitest";
import {MockLogger} from "../__mocks__/MockLogger.ts";
import {AccountService} from "../AccountService.ts";

describe("AccountService", () => {
    it("should log a message each time a deposit is added", () => {
        const mockLogger = new MockLogger();
        const accountService = new AccountService(mockLogger);

        mockLogger.expect("Deposit added: 100");
        mockLogger.expect("Deposit added: 50");

        accountService.addDeposit(100);
        accountService.addDeposit(50);

        mockLogger.verify();
    })
})