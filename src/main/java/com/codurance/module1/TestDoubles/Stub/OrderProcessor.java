package com.codurance.module1.TestDoubles.Stub;

public class OrderProcessor {
    private PaymentGateway paymentGateway;

    public OrderProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processOrder(double amount) throws PaymentChargeFailed {
        if (!paymentGateway.charge(amount)) {
            throw PaymentChargeFailed.with(amount);
        }
    }
}
