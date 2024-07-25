package com.codurance.module1.preRequisites.WhatToTest.Inventory;

import java.util.List;
import java.util.Map;

public class Inventory {
    private final Logger logger;
    private Map<String, Item> items;

    Inventory(
        Logger logger
    ) {

        this.logger = logger;
    }

    public List<Item> items() {
        return items.values().stream().toList();
    }

    public void addItem(Item item) {
        if (items.containsValue(item)) {
            addItemUnits(item);
            return;
        }

        storeItem(item);
    }

    public Item findItemBy(String id) {
        return items.get(id);
    }

    private void storeItem(Item item) {
        items.put(item.id(), item);
        logger.log(item);
    }

    private void addItemUnits(Item item) {
        Item inventoryItem = items.get(item.id());
        inventoryItem.add(item);
        logger.log(inventoryItem);
    }
}
