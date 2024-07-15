package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountShould {

    @Test
    public void increaseBalanceOnDeposit() {
        BankAccount bankAccount = new BankAccount();
        int depositAmount = 100;
        int expectedBalance = 100;

        bankAccount.deposit(depositAmount);
        int balance = bankAccount.checkBalance();

        assertEquals(expectedBalance, balance);
    }

    @Test
    public void decreaseBalanceOnWithdrawal() {
        BankAccount bankAccount = new BankAccount();
        int depositAmount = 200;
        int withdrawalAmount = 100;
        int expectedBalance = 100;

        bankAccount.deposit(depositAmount);
        bankAccount.withdraw(withdrawalAmount);
        int balance = bankAccount.checkBalance();

        assertEquals(expectedBalance, balance);
    }

    @Test
    public void notDecreaseBalanceWhenInsufficientFunds() {
        BankAccount bankAccount = new BankAccount();
        int depositAmount = 100;
        int withdrawalAmount = 200;
        int expectedBalance = 100;

        bankAccount.deposit(depositAmount);
        bankAccount.withdraw(withdrawalAmount);
        int balance = bankAccount.checkBalance();

        assertEquals(expectedBalance, balance);
    }
}