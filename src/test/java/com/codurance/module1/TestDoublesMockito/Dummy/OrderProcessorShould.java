package com.codurance.module1.TestDoublesMockito.Dummy;

import com.codurance.module1.TestDoubles.Dummy.OrderProcessor;
import com.codurance.module1.TestDoubles.Dummy.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class OrderProcessorShould {
    private final User DUMMY_USER = null;

    /**
     * You have a method that requires a complex User object, but the test doesn't use this object.
     */
    @Test
    public void create_order_id_based_on_current_order_number() {
        User user = mock(User.class);
        OrderProcessor processor = new OrderProcessor(122);
        int expectedOrderId = 123;
        int orderId = processor.processOrder(user);

        assertEquals(expectedOrderId, orderId);
    }
}
