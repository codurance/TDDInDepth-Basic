package com.codurance;

import org.assertj.core.api.AbstractAssert;

class YearAssert extends AbstractAssert<YearAssert, Year> {
    private final Year year;

    protected YearAssert(Year year) {
        super(year, YearAssert.class);
        this.year = year;
    }

    public static YearAssert assertThat(Year actual) {
        return new YearAssert(actual);
    }

    public YearAssert isLeap() {
        if (!actual.isLeap()) {
            failWithMessage("Expected %s to be a leap year".formatted(year));
        }

        return this;
    }

    public YearAssert isNotLeap() {
        if (actual.isLeap()) {
            failWithMessage("Expected %s to be not a leap year".formatted(year));
        }

        return this;
    }
}
