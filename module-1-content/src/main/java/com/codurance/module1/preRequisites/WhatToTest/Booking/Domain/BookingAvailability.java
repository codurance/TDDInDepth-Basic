package com.codurance.module1.preRequisites.WhatToTest.Booking.Domain;

import java.util.Date;
import java.util.List;

public interface BookingAvailability {
    void verify(List<Date> bookingDates) throws Exception;

    void cancel(Booking booking) throws Exception;
}
