package com.codurance.application;

public class DepositRequest {
    public String id;
    public int amount;

    public DepositRequest(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}
