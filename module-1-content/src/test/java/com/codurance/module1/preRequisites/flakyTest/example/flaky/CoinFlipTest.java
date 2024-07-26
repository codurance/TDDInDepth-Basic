package com.codurance.module1.preRequisites.flakyTest.example.flaky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinFlipTest {
    @Test
    public void testFlipCoin() {
        CoinFlip coinFlip = new CoinFlip();
        String result = coinFlip.flip();
        // This test is flaky because it depends on the randomness of the coin flip
        assertEquals("heads", result);  // Test will fail 50% of the time
    }
}
