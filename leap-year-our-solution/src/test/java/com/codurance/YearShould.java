package com.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YearShould {
    @Test
    public void notBeLeapYearWhen1997() {
        Year year = new Year(1997);

        boolean isLeapYear = year.isLeap();

        assertFalse(isLeapYear);
    }

    @ParameterizedTest
    @MethodSource("yearsDivisibleBy400")
    public void beALeapYearWhenDivisibleBy400(Year year) {
        boolean isLeapYear = year.isLeap();

        assertTrue(isLeapYear);
    }

    public static Stream<Year> yearsDivisibleBy400() {
        return Stream.of(
            new Year(1200),
            new Year(1600),
            new Year(2000)
        );
    }
}