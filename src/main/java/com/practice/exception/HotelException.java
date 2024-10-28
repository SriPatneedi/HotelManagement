package com.practice.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class HotelException extends RuntimeException {
    /**
     *
     * @param message
     */
    public HotelException(final String message) {
        super(message);
    }
}
