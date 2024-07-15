import {PaymentGateway} from "./PaymentGateway.ts";
import {PaymentChargeFailed} from "./PaymentChargeFailed.ts";

export class OrderProcessor {
    private readonly paymentGateway: PaymentGateway;

    constructor(paymentGateway: PaymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public processOrder(amount: number): void {
        if (!this.paymentGateway.charge(amount)) {
            throw PaymentChargeFailed.with(amount);
        }
    }
}