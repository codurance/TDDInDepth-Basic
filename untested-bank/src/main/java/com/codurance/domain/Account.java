package com.codurance.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    public final UUID id;
    private final List<AccountTransaction> transactions = new ArrayList<>();

    public Account(UUID uuid) {
        this.id = uuid;
    }

    public Account(UUID id, List<AccountTransaction> transactions) {
        this.id = id;
        this.transactions.addAll(transactions);
    }

    public List<AccountTransaction> getTransactions() {
        return List.copyOf(transactions);
    }

    public void addTransaction(AccountTransaction amount) {
        transactions.add(amount);
    }
}
