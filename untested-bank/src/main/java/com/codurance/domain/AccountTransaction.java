package com.codurance.domain;

import java.util.Date;
import java.util.UUID;

public class AccountTransaction {
    public final UUID id;
    public final Date date;
    public final int amount;

    public AccountTransaction(UUID id, Date date, int amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }
}
