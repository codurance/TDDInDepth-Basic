package com.codurance.module1.TestDoubles.Fake;

public class OrderService {
    private final OrderRepository orderRepository;

    OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public void createOrder(OrderId orderId) {
        orderRepository.save(new Order(orderId));
    }

    public Order getOrder(OrderId orderId) {
        return orderRepository.get(orderId);
    }
}
