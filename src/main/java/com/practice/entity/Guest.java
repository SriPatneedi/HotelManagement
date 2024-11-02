package com.practice.entity;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Component
public class Guest extends User {
    @OneToMany(mappedBy = "guestId",
            cascade = CascadeType.ALL)
    private List<Booking> bookings;

    /**
     * Constructor.
     */
    public Guest() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Getter for booking.
     * @return list of bookings
     */
    public List<Booking> getBookings() {
        if (this.bookings == null) {
            this.bookings = new ArrayList<>();
        }
        return bookings;
    }
}
