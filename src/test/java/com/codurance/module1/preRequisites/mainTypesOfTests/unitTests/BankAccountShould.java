package com.codurance.module1.preRequisites.mainTypesOfTests.unitTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountShould {

    @Test
    public void increaseBalanceAfterDeposit() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.deposit(100);

        assertEquals(100, bankAccount.checkBalance());
    }

    @Test
    public void decreaseBalanceAfterWithdrawal() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.deposit(200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.checkBalance());
    }

    @Test
    public void notDecreaseBalanceAfterWithdrawalWithInsufficientFunds() {
        BankAccount bankAccount = new BankAccount();

        bankAccount.deposit(100);
        bankAccount.withdraw(200);

        assertEquals(100, bankAccount.checkBalance());
    }
}