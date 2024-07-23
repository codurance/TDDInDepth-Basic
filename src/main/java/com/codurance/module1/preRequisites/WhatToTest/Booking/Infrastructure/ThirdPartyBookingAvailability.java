package com.codurance.module1.preRequisites.WhatToTest.Booking.Infrastructure;

import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.Booking;
import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.BookingAvailability;
import jdk.jshell.spi.ExecutionControl;

import java.util.Date;
import java.util.List;

public class ThirdPartyBookingAvailability implements BookingAvailability {
    @Override
    public void verify(List<Date> bookingDates) throws Exception {
        throw new ExecutionControl.NotImplementedException("Calling to external service from a test.");
    }

    @Override
    public void cancel(Booking booking) throws Exception {
        throw new ExecutionControl.NotImplementedException("Calling to external service from a test.");
    }
}
