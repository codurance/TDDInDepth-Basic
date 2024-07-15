import {it, describe, expect} from "vitest";
import {OrderProcessor} from "../OrderProcessor.ts";
import {User} from "../User.ts";

describe("OrderProcessor", () => {
    it("create order id based on current order number", () => {
        const orderProcessor = new OrderProcessor(122);
        const expectedOrderId = 123;

        const orderId = orderProcessor.processOrder(null as unknown as User);

        expect(orderId).toBe(expectedOrderId);
    })
})