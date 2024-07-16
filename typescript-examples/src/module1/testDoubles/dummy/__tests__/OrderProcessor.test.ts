import { describe, expect, it, vi } from "vitest";
import { OrderProcessor } from "../OrderProcessor.ts";
import { User } from "../User.ts";

describe("OrderProcessor", () => {
    it("should create order id based on current order number", () => {
        const user = vi.mocked(User);
        const expectedOrderId = 123;
        const orderProcessor = new OrderProcessor(122);

        const orderId = orderProcessor.processOrder(user);

        expect(orderId).toBe(expectedOrderId);
    });
});
