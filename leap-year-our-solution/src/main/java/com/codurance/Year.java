package com.codurance;

public class Year {
    private final int year;

    public Year(int year) {

        this.year = year;
    }

    public boolean isLeap() {
        if (isDivisibleBy100()) {
            return isYearDivisibleBy400();
        }

        return isYearDivisibleBy4();
    }

    private boolean isDivisibleBy100() {
        return year % 100 == 0;
    }

    private boolean isYearDivisibleBy4() {
        return year % 4 == 0;
    }

    private boolean isYearDivisibleBy400() {
        return year % 400 == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(year);
    }
}
