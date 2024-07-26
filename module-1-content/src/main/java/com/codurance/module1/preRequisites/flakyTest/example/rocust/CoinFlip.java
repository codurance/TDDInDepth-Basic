package com.codurance.module1.preRequisites.flakyTest.example.rocust;

import java.util.function.BooleanSupplier;

public class CoinFlip {
    private BooleanSupplier randomSupplier;

    public CoinFlip(BooleanSupplier randomSupplier) {
        this.randomSupplier = randomSupplier;
    }

    public String flip() {
        return randomSupplier.getAsBoolean() ? "heads" : "tails";
    }
}
