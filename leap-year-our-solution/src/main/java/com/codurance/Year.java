package com.codurance;

public class Year {
    private final int year;

    public Year(int year) {

        this.year = year;
    }

    public boolean isLeap() {
        if (isYearDivisibleBy4()) {
            return true;
        }

        return isYearDivisibleBy400();
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
