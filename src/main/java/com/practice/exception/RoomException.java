package com.practice.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class RoomException extends RuntimeException {
    /**
     *
     * @param message
     */
    public RoomException(final String message) {
        super(message);
    }
}
