import { describe, expect, it, vi } from "vitest";
import { OrderProcessor } from "../OrderProcessor.ts";
import { PaymentChargeFailed } from "../PaymentChargeFailed.ts";
import { PaymentGateway } from "../PaymentGateway.ts";

describe("OrderProcessor", () => {
    it("should throw payment charge failed exception after failing to make a charge", () => {
        const paymentGateway: PaymentGateway = {
            charge: vi.fn().mockReturnValue(false),
        };
        const orderProcessor = new OrderProcessor(paymentGateway);

        expect(() => {
            orderProcessor.processOrder(300);
        }).toThrow(PaymentChargeFailed);
    });
});
