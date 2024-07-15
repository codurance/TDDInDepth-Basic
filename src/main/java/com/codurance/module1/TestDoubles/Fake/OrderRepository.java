package com.codurance.module1.TestDoubles.Fake;

public interface OrderRepository {
    public void save(Order order);
    public Order get(OrderId key);
}
