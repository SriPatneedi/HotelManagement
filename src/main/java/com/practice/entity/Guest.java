package com.practice.entity;

import lombok.NoArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "GUEST")
public class Guest extends User {
    @OneToMany(mappedBy = "guest",
            cascade = CascadeType.ALL)
    private List<Booking> bookings;

    /**
     * Constructor.
     * @param name the name of guest
     * @param email the email of guest
     * @param contactNumber guest contact number
     */
    public Guest(final String name,
            final String email,
            final String contactNumber) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = contactNumber;
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
