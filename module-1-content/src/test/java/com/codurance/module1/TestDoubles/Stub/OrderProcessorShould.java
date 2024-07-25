package com.codurance.module1.TestDoubles.Stub;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderProcessorShould {
    /**
     * we want to test order processing without calling the real payment gateway.
     */
    @Test
    public void throw_payment_charge_failed_exception_after_failing_to_make_a_charge() throws Exception {
        PaymentGateway paymentGatewayStub = new FailingPaymentGatewayStub();
        OrderProcessor processor = new OrderProcessor(paymentGatewayStub);

        assertThrows(PaymentChargeFailed.class, () -> {
            processor.processOrder(300);
        });
    }
}
