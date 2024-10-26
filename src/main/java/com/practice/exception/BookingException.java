package com.practice.exception;

public class BookingException extends RuntimeException {
    /**
     *
     * @param message
     */
    public BookingException(final String message) {
        super(message);
    }
}
