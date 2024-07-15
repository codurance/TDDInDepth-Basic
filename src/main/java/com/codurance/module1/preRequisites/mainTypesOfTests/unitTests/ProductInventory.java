package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void addStock(String productId, int quantity) {
        inventory.put(productId, checkStock(productId) + quantity);
    }

    public void removeStock(String productId, int quantity) {
        int currentStock = checkStock(productId);
        if (currentStock < quantity) {
            throw new IllegalArgumentException("Not enough stock available for " + productId);
        }
        inventory.put(productId, currentStock - quantity);
    }

    public int checkStock(String productId) {
        return inventory.getOrDefault(productId, 0);
    }
}
