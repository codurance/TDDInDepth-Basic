package com.codurance.module1.TestDoubles.Dummy;

public class OrderProcessor {

    private int orderCount;

    OrderProcessor(int orderCount) {

        this.orderCount = orderCount;
    }

    public int processOrder(User user) {
        orderCount++;

        int orderId = orderCount;

        // The user object is not used in this test
        System.out.println("Processing order " + orderId);

        return orderId;
    }

}
