package com.practice.service;

import com.practice.entity.Booking;
import com.practice.entity.Payment;
import com.practice.entity.Room;
import com.practice.repository.BookingRepository;
import com.practice.repository.PaymentRepository;
import com.practice.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;
    private BookingRepository bookingRepository;
    private RoomRepository roomRepository;

    public PaymentServiceImpl(PaymentRepository repository, BookingRepository bookingRepository, RoomRepository roomRepository){
        this.paymentRepository = repository;
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public Payment createPayment(String bookingId, Payment payment){
        Booking booking = bookingRepository.getById(bookingId);
        List<String> bookedRoomIds = booking.getRoomIds();
        for(int i = 0; i < bookedRoomIds.size(); i++){
            Room room = roomRepository.findById(bookedRoomIds.get(i))
                    .orElseThrow(() -> new EntityNotFoundException("Unable to find the entity with the id."));
            room.setStatus(Room.STATUS.CONFIRMED);
            roomRepository.save(room);
        }
        booking.setStatus(Booking.BOOKINGSTATUS.CONFIRMED);
        bookingRepository.save(booking);
        return paymentRepository.save(payment);
    }

    public Payment makePayment(String bookingId, double amount, Payment.PAYMENTTYPE type){
        if(type == Payment.PAYMENTTYPE.CREDITCARD || type == Payment.PAYMENTTYPE.PAYPAL){
            Payment payment = new Payment();
            payment.setAmount(amount);
            payment.setPaymentType(type);
            payment.setPaymentStatus(Payment.PAYMENTSTATUS.SUCCESSFUL);
            return this.createPayment(bookingId, payment);
        }else{
            Booking booking = bookingRepository.getById(bookingId);
            booking.setStatus(Booking.BOOKINGSTATUS.CANCELED);
            bookingRepository.save(booking);
        }
        return null;
    }

    public List<Payment> getPayments(){
        return paymentRepository.findAll();
    }

}
