package com.practice.exception;

public class PaymentException extends RuntimeException {
    /**
     *
     * @param message
     */
    public PaymentException(final String message) {
        super(message);
    }
}
