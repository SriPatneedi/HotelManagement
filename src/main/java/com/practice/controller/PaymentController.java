package com.practice.controller;

import com.practice.entity.Payment;
import com.practice.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService service){
        this.paymentService = service;
    }

    @PostMapping
    public ResponseEntity<?> makePayment(@RequestParam("bookingId") String id,
                                         @RequestParam("amount") double amount,
                                         @RequestParam("paymentType") Payment.PAYMENTTYPE type) {
        try {
            return new ResponseEntity<>(paymentService.makePayment(id, amount,type), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
