import {describe, expect, it} from "vitest";
import {OrderProcessor} from "../OrderProcessor.ts";
import {PaymentChargeFailed} from "../PaymentChargeFailed.ts";
import {FailingPaymentGatewayStub} from "../__mocks__/FailingPaymentGatewayStub.ts";

describe("OrderProcessor", () => {
    it("should throw payment charge failed exception after failing to make a charge", () => {
        const paymentGatewayStub = new FailingPaymentGatewayStub();
        const orderProcessor = new OrderProcessor(paymentGatewayStub);

        expect(() => {
            orderProcessor.processOrder(300);
        }).toThrow(PaymentChargeFailed)
    })
})