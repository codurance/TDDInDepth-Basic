package com.codurance.module1.preRequisites.WhatToTest.Booking.Application;


import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.Booking;
import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.BookingId;
import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.Traveler;

import java.util.Date;
import java.util.List;

public class BookingRequest {

    private final BookingId bookingId;
    private final Date checkin;
    private final Date checkOut;
    private final Traveler[] travelers;

    BookingRequest(
        BookingId bookingId,
        Date checkIn,
        Date checkOut,
        Traveler ...travelers
    ) {

        this.bookingId = bookingId;
        this.checkin = checkIn;
        this.checkOut = checkOut;
        this.travelers = travelers;
    }

    public List<Date> bookingDates() {
        return List.of(checkin, checkOut);
    }

    public Booking createBooking() {
        return new Booking(
            bookingId,
            bookingDates(),
            travelers
        );
    }
}
