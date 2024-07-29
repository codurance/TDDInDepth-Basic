package com.codurance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class YearShould {
    @Test
    public void notBeLeapYearWhen1997() {
        Year year = new Year(1997);

        boolean isLeapYear = year.isLeap();

        assertFalse(isLeapYear);
    }
}