package com.codurance;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YearProperties
{
    @Property
    public void yearsDivisibleBy400AreLeapYears(@ForAll("yearsDivisibleBy400") int yearDivisibleBy400) {
        Year year = new Year(yearDivisibleBy400);

        boolean isLeapYear = year.isLeap();

        assertTrue(isLeapYear);
    }

    @Provide
    private Arbitrary<Integer> yearsDivisibleBy400() {
        return Arbitraries.integers().between(1, 100).map(year -> year * 400);
    }
}
