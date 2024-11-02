package com.practice.service;

import com.practice.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(String bookingId, Payment payment);
    Payment makePayment(String bookingId, double amount, Payment.PAYMENTTYPE type);
    List<Payment> getPayments();
}
