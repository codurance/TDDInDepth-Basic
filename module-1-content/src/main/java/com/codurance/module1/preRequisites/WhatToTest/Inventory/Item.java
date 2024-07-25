package com.codurance.module1.preRequisites.WhatToTest.Inventory;

public class Item {

    private final String id;
    private Integer units;

    public Item(String id, Integer units) {
        this.id = id;
        this.units = units;
    }

    public String id() {
        return id;
    }

    public Integer units() {
        return units;
    }

    public void add(Item item) {
        if (!item.id().equals(id)) {
            return;
        }

        units += item.units;
    }
}
