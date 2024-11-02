package com.practice.service;

import com.practice.entity.Booking;

public interface BookingService {
    Booking getById(String id);
    Booking cancelBooking(String bookingId);
}
