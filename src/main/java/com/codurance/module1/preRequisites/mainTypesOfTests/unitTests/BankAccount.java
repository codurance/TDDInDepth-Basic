package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

public class BankAccount {
    private int balance;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (hasInsufficientFunds(amount)) {
            return;
        }

        balance -= amount;
    }

    public int checkBalance() {
        return balance;
    }

    private boolean hasInsufficientFunds(int amount) {
        return amount > balance;
    }
}
