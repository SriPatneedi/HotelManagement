package com.practice.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PaymentException extends RuntimeException {
    /**
     *
     * @param message
     */
    public PaymentException(final String message) {
        super(message);
    }
}
