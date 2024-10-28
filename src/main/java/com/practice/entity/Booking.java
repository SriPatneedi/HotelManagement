package com.practice.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Component
public class Booking {
    /**
     * Represents the status of the booking.
     */
    private enum BOOKINGSTATUS {
        CONFIRMED, CANCELED
    }

    @Id
    @Setter(AccessLevel.NONE)
    @Column
    private String id;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guestDetails;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotelDetails;

    @Setter(AccessLevel.NONE)
    @ElementCollection
    @CollectionTable(name = "Booking_Room_details",
            joinColumns = @JoinColumn(name = "booking_id"))
    @Column
    private List<String> roomDetails;

    @Column
    private LocalDate checkInDate;

    @Column
    private LocalDate checkOutDate;

    @Column
    private BOOKINGSTATUS status;

    /**
     * once booking object is created generating a random Id for the
     * booking ID of the current object.
     */
    public Booking() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Getter for room details.
     * @return list of rooms
     */
    public List<String> getRoomDetails() {
        if (this.roomDetails == null) {
            this.roomDetails = new ArrayList<>();
        }
        return roomDetails;
    }
}
