package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YearShould {
    @Test
    public void notBeLeapYearWhen1997() {
        Year year = new Year(1997);

        boolean isLeapYear = year.isLeap();

        assertFalse(isLeapYear);
    }

    @Test
    public void beALeapYearWhen1600() {
        Year year = new Year(1600);

        boolean isLeapYear = year.isLeap();

        assertTrue(isLeapYear);
    }

    @Test
    public void beALeapYearWhen1200() {
        Year year = new Year(1200);

        boolean isLeapYear = year.isLeap();

        assertTrue(isLeapYear);
    }
}