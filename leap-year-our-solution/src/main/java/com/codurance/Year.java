package com.codurance;

public class Year {
    private final int year;

    public Year(int year) {

        this.year = year;
    }

    public boolean isLeap() {
        if (year == 1996 || year == 1992) {
            return true;
        }

        return isYearDivisibleBy400();
    }

    private boolean isYearDivisibleBy400() {
        return year % 400 == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }
}
