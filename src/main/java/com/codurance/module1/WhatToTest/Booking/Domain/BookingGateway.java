package com.codurance.module1.WhatToTest.Booking.Domain;

import java.util.List;

public interface BookingGateway {
    void save(Booking booking) throws Exception;

    Booking findBy(BookingId id) throws Exception;

    List<Booking> findAll() throws Exception;
}
