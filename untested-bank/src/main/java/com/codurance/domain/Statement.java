package com.codurance.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Statement {
    public final List<StatementLine> statementLines;

    private Statement(List<StatementLine> statementLines) {
        this.statementLines = statementLines;
    }

    public static Statement from(List<AccountTransaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);

        List<StatementLine> statementLines = transactions.stream().map(transaction -> {
            runningBalance.addAndGet(transaction.amount);
            return new StatementLine(transaction.amount, transaction.date, runningBalance.get());
        }).toList();

        return new Statement(statementLines.reversed());
    }
}
