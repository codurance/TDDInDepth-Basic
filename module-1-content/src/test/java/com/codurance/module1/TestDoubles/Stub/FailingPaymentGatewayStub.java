package com.codurance.module1.TestDoubles.Stub;

public class FailingPaymentGatewayStub implements PaymentGateway {
    @Override
    public boolean charge(double amount) {
        // Always return false for testing purposes
        return false;
    }

}
