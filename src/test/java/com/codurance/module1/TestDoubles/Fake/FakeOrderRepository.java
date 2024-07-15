package com.codurance.module1.TestDoubles.Fake;


import java.util.ArrayList;
import java.util.List;

public class FakeOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<Order>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public Order get(OrderId orderId) {
        return orders.stream()
            .filter(order -> order.orderId().equals(orderId))
            .findFirst()
            .orElse(null);
    }
}
