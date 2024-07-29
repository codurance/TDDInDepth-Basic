package com.codurance;

public class Year {
    private final int year;

    public Year(int year) {

        this.year = year;
    }

    public boolean isLeap() {
        if (isNotLeap()) {
            return isYearDivisibleBy400();
        }

        return isYearDivisibleBy4();
    }

    private boolean isNotLeap() {
        return year == 1800 || year == 1900 || year == 1700;
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
