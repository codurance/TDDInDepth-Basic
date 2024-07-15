package com.codurance.module1.TestDoubles.Fake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceShould {

    /**
     * You want to test data access logic without hitting the real database.
     */
    @Test
    public void create_an_order() {
        OrderId expectedOrderId = new OrderId(123);

        OrderService orderService = new OrderService(new FakeOrderRepository());
        orderService.createOrder(expectedOrderId);

        Order order = orderService.getOrder(expectedOrderId);
        assertEquals(expectedOrderId, order.orderId());
    }
}
