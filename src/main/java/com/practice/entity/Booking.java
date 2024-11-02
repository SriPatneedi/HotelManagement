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
    public enum BOOKINGSTATUS {
        CONFIRMED, ONHOLD, CANCELED
    }

    @Id
    @Setter(AccessLevel.NONE)
    @Column
    private String id;

    //@ManyToOne
    //@JoinColumn(name = "guest_id")
    private String guestId;

    //@ManyToOne
    //@JoinColumn(name = "hotel_id")
    private int hotelId;

    @Setter(AccessLevel.NONE)
    @ElementCollection
    @CollectionTable(name = "Booking_Room_details",
            joinColumns = @JoinColumn(name = "booking_id"))
    @Column
    private List<String> roomIds;

    @Column
    private double amount;

    @Column
    private LocalDate checkInDate;

    @Column
    private LocalDate checkOutDate;

    @Column
    public BOOKINGSTATUS status;

    /**
     * once booking object is created generating a random Id for the
     * booking ID of the current object.
     */
    public Booking() {
        this.id = UUID.randomUUID().toString();
    }

    public Booking(int hotelId, String guestId, double amount, LocalDate checkInDate, LocalDate checkOutDate, List<String> roomDetails, BOOKINGSTATUS status){
        this.id = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.guestId = guestId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomIds = roomDetails;
        this.amount = amount;
        this.status = status;
    }

    /**
     * Getter for room details.
     * @return list of rooms
     */
    public List<String> getRoomIds() {
        if (this.roomIds == null) {
            this.roomIds = new ArrayList<>();
        }
        return roomIds;
    }
}
