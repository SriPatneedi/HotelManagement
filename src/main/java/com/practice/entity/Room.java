package com.practice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ROOM",
        uniqueConstraints = @UniqueConstraint(columnNames =
                {"roomNo", "hotel_id"})
)
public class Room {
    public enum STATUS {
        AVAILABLE, RESERVED, OCCUPIED
    }
    @Id
    private String id;
    @Column
    private int roomNo;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Column(name = "type")
    private Hotel.ROOMTYPE type;
    @Column(name = "price")
    private int price;
    @Column(name = "status")
    private STATUS status;

    /**
     * Room constructor.
     * @param hotelDetails hotel details
     * @param roomModel type of the room
     * @param roomNumber room number
     * @param cost price of the room
     */
    public Room(final Hotel hotelDetails,
                final Hotel.ROOMTYPE roomModel,
                final int roomNumber,
                final int cost) {
        this.id = UUID.randomUUID().toString();
        this.hotel = hotelDetails;
        this.type = roomModel;
        this.roomNo = roomNumber;
        this.price = cost;
    }
}
