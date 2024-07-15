import {PaymentGateway} from "../PaymentGateway.ts";

export class FailingPaymentGatewayStub implements PaymentGateway {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    charge(_amount: number): boolean {
        return false;
    }
}