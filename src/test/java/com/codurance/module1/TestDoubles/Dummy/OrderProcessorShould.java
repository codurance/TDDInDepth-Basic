package com.codurance.module1.TestDoubles.Dummy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderProcessorShould {
    private final User DUMMY_USER = null;

    /**
     * You have a method that requires a complex User object, but the test doesn't use this object.
     */
    @Test
    public void create_order_id_based_on_current_order_number() {
        OrderProcessor processor = new OrderProcessor(122);
        int expectedOrderId = 123;
        int orderId = processor.processOrder(DUMMY_USER);

        assertEquals(expectedOrderId, orderId);
    }
}
