package com.codurance.module1.TestDoubles.Mock;

public class AccountService {
    private Logger logger;

    public AccountService(Logger logger) {
        this.logger = logger;
    }

    public void addDeposit(double amount) {
        // Here goes the "add deposit" logic

        logger.log("Deposit added: " + amount);
    }
}
