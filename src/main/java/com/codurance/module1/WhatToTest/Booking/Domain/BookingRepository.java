package com.codurance.module1.WhatToTest.Booking.Domain;

import java.util.List;

public class BookingRepository {
    private final BookingGateway bookingGateway;

    BookingRepository(
        BookingGateway bookingGateway
    ) {

        this.bookingGateway = bookingGateway;
    }

    public void save(Booking booking) {
        bookingGateway.save(booking);
    }

    public void cancel(Booking booking) {
        booking.cancel();
        save(booking);
    }

    public Booking get(BookingId id) {
        return bookingGateway.findBy(id);
    }

    public List<Booking> all() {
        return bookingGateway.findAll();
    }
}
