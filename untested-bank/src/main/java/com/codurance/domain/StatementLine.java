package com.codurance.domain;

import java.util.Date;
import java.util.Objects;

public class StatementLine {
    private final int amount;
    private final Date date;
    private final int balance;

    public StatementLine(int amount, Date date, int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "StatementLine{" +
            "amount=" + amount +
            ", date=" + date +
            ", balance=" + balance +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatementLine that)) return false;
        return amount == that.amount && balance == that.balance && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date, balance);
    }
}
