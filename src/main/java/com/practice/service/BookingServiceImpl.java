package com.practice.service;

import com.practice.entity.Booking;
import com.practice.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository repository){
        this.bookingRepository = repository;
    }

    public Booking getById(String id){
        return bookingRepository.getById(id);
    }

    public Booking cancelBooking(String bookingId){
        Booking booking = bookingRepository.getById(bookingId);
        booking.setStatus(Booking.BOOKINGSTATUS.CANCELED);
        bookingRepository.save(booking);
        return booking;
    }

}
