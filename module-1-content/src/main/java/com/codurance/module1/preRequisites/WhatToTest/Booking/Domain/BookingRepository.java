package com.codurance.module1.preRequisites.WhatToTest.Booking.Domain;

import java.util.List;

public class BookingRepository {
    private final BookingGateway bookingGateway;

    BookingRepository(
        BookingGateway bookingGateway
    ) {

        this.bookingGateway = bookingGateway;
    }

    public void save(Booking booking) throws Exception {
        bookingGateway.save(booking);
    }

    public void cancel(Booking booking) throws Exception {
        booking.cancel();
        save(booking);
    }

    public Booking get(BookingId id) throws Exception {
        return bookingGateway.findBy(id);
    }

    public List<Booking> all() throws Exception {
        return bookingGateway.findAll();
    }
}
