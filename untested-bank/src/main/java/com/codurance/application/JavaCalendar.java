package com.codurance.application;

import com.codurance.domain.Calendar;

import java.util.Date;

public class JavaCalendar implements Calendar {
    @Override
    public Date today() {
        return new Date();
    }
}
