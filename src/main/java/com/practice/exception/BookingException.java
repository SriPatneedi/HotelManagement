package com.practice.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class BookingException extends RuntimeException {
    /**
     *
     * @param message
     */
    public BookingException(final String message) {
        super(message);
    }
}
