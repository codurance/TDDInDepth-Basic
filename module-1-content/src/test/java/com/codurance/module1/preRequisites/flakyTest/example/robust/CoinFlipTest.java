package com.codurance.module1.preRequisites.flakyTest.example.robust;

import com.codurance.module1.preRequisites.flakyTest.example.rocust.CoinFlip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinFlipTest {
    @Test
    public void testFlipCoinHeads() {
        CoinFlip coinFlip = new CoinFlip(() -> true);
        String result = coinFlip.flip();
        assertEquals("heads", result);
    }

    @Test
    public void testFlipCoinTails() {
        CoinFlip coinFlip = new CoinFlip(() -> false);
        String result = coinFlip.flip();
        assertEquals("tails", result);
    }
}
