package com.codurance.module1.TestDoubles.Fake;

public class Order {
    private final OrderId orderId;

    Order(OrderId orderId) {

        this.orderId = orderId;
    }

    public OrderId orderId() {
        return orderId;
    }
}
