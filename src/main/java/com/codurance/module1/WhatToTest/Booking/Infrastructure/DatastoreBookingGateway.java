package com.codurance.module1.WhatToTest.Booking.Infrastructure;

import com.codurance.module1.WhatToTest.Booking.Domain.Booking;
import com.codurance.module1.WhatToTest.Booking.Domain.BookingGateway;
import com.codurance.module1.WhatToTest.Booking.Domain.BookingId;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class DatastoreBookingGateway implements BookingGateway {
    @Override
    public void save(Booking booking) throws Exception {
        throw new ExecutionControl.NotImplementedException("Calling to a Datastore.");
    }

    @Override
    public Booking findBy(BookingId id) throws Exception {
        throw new ExecutionControl.NotImplementedException("Calling to a Datastore.");
    }

    @Override
    public List<Booking> findAll() throws Exception {
        throw new ExecutionControl.NotImplementedException("Calling to a Datastore.");
    }
}
