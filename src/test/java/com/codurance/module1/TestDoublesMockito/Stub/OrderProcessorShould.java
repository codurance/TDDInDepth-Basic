package com.codurance.module1.TestDoublesMockito.Stub;

import com.codurance.module1.TestDoubles.Stub.OrderProcessor;
import com.codurance.module1.TestDoubles.Stub.PaymentChargeFailed;
import com.codurance.module1.TestDoubles.Stub.PaymentGateway;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderProcessorShould {
    /**
     * we want to test order processing without calling the real payment gateway.
     */
    @Test
    public void throw_payment_charge_failed_exception_after_failing_to_make_a_charge() throws Exception {
        PaymentGateway paymentGateway = mock(PaymentGateway.class);
        when(paymentGateway.charge(300)).thenReturn(false);

        OrderProcessor processor = new OrderProcessor(paymentGateway);

        assertThrows(PaymentChargeFailed.class, () -> {
            processor.processOrder(300);
        });
    }
}
