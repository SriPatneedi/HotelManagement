package com.practice.entity;

import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Setter
@Entity
@Component
public class Payment {
    public enum PAYMENTTYPE {
        PAYPAL, CREDITCARD
    }
    public enum PAYMENTSTATUS {
        SUCCESSFUL, FAILED
    }

    @Setter(AccessLevel.NONE)
    @Id
    @Column
    private String id;
    @Column
    private double amount;
    @Column
    private PAYMENTSTATUS paymentStatus;
    @Column
    private PAYMENTTYPE paymentType;

    /**
     * No args constructor for payment.
     */
    public Payment() {
        this.id = UUID.randomUUID().toString();
    }
}
/*
    public PAYMENTSTATUS makePayment(final int totalAmount,
                                     final PAYMENTTYPE paymentMode) {
        if (paymentMode.equals(PAYMENTTYPE.PAYPAL)
                || paymentMode.equals(PAYMENTTYPE.CREDITCARD)) {
            System.out.println("PAYMENT SUCCESSFUL");
            this.paymentId = UUID.randomUUID().toString();
            this.amount = totalAmount;
            this.paymentStatus = PAYMENTSTATUS.SUCCESSFUL;
        } else {
            System.out.println("Payment not Successful. Try Again!");
            this.paymentStatus = PAYMENTSTATUS.FAILED;
            throw new PaymentException("Invalid PaymentType!");
        }
        return paymentStatus;
    }*/
