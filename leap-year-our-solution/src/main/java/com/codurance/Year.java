package com.codurance;

public class Year {
    private final int year;

    public Year(int year) {

        this.year = year;
    }

    public boolean isLeap() {
        return isYearDivisibleBy400();
    }

    private boolean isYearDivisibleBy400() {
        return year == 1600 || year == 1200 || year == 2000;
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }
}
