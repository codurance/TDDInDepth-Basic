package com.codurance.domain;

import java.util.Date;

public class StatementLine {
    private final int amount;
    private final Date date;
    private final int balance;

    public StatementLine(int amount, Date date, int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }
}
