package com.codurance.module1.WhatToTest.Booking.Domain;

import jdk.jshell.spi.ExecutionControl;

import java.util.Date;
import java.util.List;

public interface BookingAvailability {
    void verify(List<Date> bookingDates) throws Exception;

    void cancel(Booking booking) throws Exception;
}
