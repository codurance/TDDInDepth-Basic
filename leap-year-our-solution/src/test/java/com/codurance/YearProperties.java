package com.codurance;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;

import static com.codurance.YearAssert.assertThat;

public class YearProperties {
    @Property
    public void yearsDivisibleBy400AreLeapYears(@ForAll("yearsDivisibleBy400") @Positive int yearDivisibleBy400) {
        Year year = new Year(yearDivisibleBy400);

        assertThat(year).isLeap();
    }

    @Property
    public void yearsDivisibleBy4AreLeapYears(@ForAll("yearsDivisibleBy4") @Positive int yearDivisibleBy4) {
        Assume.that(isNotDivisibleBy100(yearDivisibleBy4));
        Year year = new Year(yearDivisibleBy4);

        assertThat(year).isLeap();
    }

    @Property
    public void yearsDivisibleBy4And100ButNot400AreNotLeapYears(@ForAll("yearsDivisibleBy100") @Positive int yearDivisibleBy4And100ButNot400) {
        Assume.that(isNotDivisibleBy400(yearDivisibleBy4And100ButNot400));
        Year year = new Year(yearDivisibleBy4And100ButNot400);

        assertThat(year).isNotLeap();
    }

    @Provide
    private Arbitrary<Integer> yearsDivisibleBy400() {
        return Arbitraries.integers().between(1, 10000).map(year -> year * 400);
    }

    @Provide
    private Arbitrary<Integer> yearsDivisibleBy4() {
        return Arbitraries.integers().between(1, 10000).map(year -> year * 4);
    }

    @Provide
    private Arbitrary<Integer> yearsDivisibleBy100() {
        return Arbitraries.integers().between(1, 10000).map(year -> year * 100);
    }

    private static boolean isNotDivisibleBy400(int yearDivisibleBy4And100ButNot400) {
        return yearDivisibleBy4And100ButNot400 % 400 != 0;
    }

    private static boolean isNotDivisibleBy100(int yearDivisibleBy4) {
        return yearDivisibleBy4 % 100 != 0;
    }
}
