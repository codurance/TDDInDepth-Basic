package com.codurance.module1.preRequisites.WhatToTest.Booking.Domain;

import java.util.List;

public interface BookingGateway {
    void save(com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.Booking booking) throws Exception;

    com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.Booking findBy(BookingId id) throws Exception;

    List<Booking> findAll() throws Exception;
}
