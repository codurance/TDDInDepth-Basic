package com.codurance.module1.preRequisites.flakyTest.example.flaky;

import java.util.Random;

public class CoinFlip {
    private Random random;

    public CoinFlip() {
        this.random = new Random();
    }

    public String flip() {
        return random.nextBoolean() ? "heads" : "tails";
    }
}
