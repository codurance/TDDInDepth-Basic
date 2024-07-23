package com.codurance.module1.preRequisites.WhatToTest.Booking.Domain;

import java.util.Date;
import java.util.List;

public class Booking {
    private final BookingId bookingId;
    private final List<Date> dates;
    private final Traveler[] travelers;
    private boolean cancelled = false;

    public Booking(BookingId bookingId, List<Date> dates, Traveler[] travelers) {

        this.bookingId = bookingId;
        this.dates = dates;
        this.travelers = travelers;
    }

    public void cancel() {
        cancelled = true;
    }
}
