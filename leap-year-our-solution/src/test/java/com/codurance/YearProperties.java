package com.codurance;

import net.jqwik.api.*;

import static com.codurance.YearAssert.assertThat;

public class YearProperties {
    @Property
    public void yearsDivisibleBy400AreLeapYears(@ForAll("yearsDivisibleBy400") int yearDivisibleBy400) {
        Year year = new Year(yearDivisibleBy400);

        assertThat(year).isLeap();
    }

    @Property
    public void yearsDivisibleBy4AreLeapYears(@ForAll("yearsDivisibleBy4") int yearDivisibleBy4) {
        Assume.that(yearDivisibleBy4 % 100 != 0);
        Year year = new Year(yearDivisibleBy4);

        assertThat(year).isLeap();
    }

    @Provide
    private Arbitrary<Integer> yearsDivisibleBy400() {
        return Arbitraries.integers().map(year -> year * 400);
    }

    @Provide
    private Arbitrary<Integer> yearsDivisibleBy4() {
        return Arbitraries.integers().map(year -> year * 4);
    }
}
