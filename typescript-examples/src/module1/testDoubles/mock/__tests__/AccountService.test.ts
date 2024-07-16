import { describe, expect, it, vi } from "vitest";
import { AccountService } from "../AccountService.ts";
import { Logger } from "../Logger.ts";

describe("AccountService", () => {
    it("should log a message each time a deposit is added", () => {
        const logger: Logger = {
            log: vi.fn(),
        };
        const accountService = new AccountService(logger);

        accountService.addDeposit(100);
        accountService.addDeposit(50);

        expect(logger.log).toHaveBeenNthCalledWith(1, "Deposit added: 100");
        expect(logger.log).toHaveBeenNthCalledWith(2, "Deposit added: 50");
    });
});
