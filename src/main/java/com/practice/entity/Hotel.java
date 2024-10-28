package com.practice.entity;

import com.practice.exception.HotelException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Component
@NoArgsConstructor
public class Hotel {

    public enum ROOMTYPE {
        STANDARD, DELUXE, SUITE
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "rating")
    private double rating;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;
    @OneToMany(mappedBy = "hotelDetails", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    /**
     * Constructor for hotel.
     * @param hotelName hotel name
     * @param hotelLocation hotel location
     * @param hotelRating rating of the hotel
     * @throws HotelException if any of the input hotelLocation,
     * name is null.
     */
    /*@Autowired
    public Hotel(final String hotelName,
                 final String hotelLocation,
                 final double hotelRating) {
        if (hotelName == "" || hotelLocation == "") {
            throw new HotelException("Hotel details can't be Empty.");
        }

        this.name = hotelName;
        this.location = hotelLocation;
        this.rating = hotelRating;
    }*/

    /**
     * getter for rooms.
     * @return list of rooms
     */
    public List<Room> getRooms() {
        if (this.rooms == null) {
            this.rooms = new ArrayList<>();
        }
        return rooms;
    }

    /**
     * Getter for bookings.
     * @return bookings list
     */
    public List<Booking> getBookings() {
        if (this.bookings == null) {
            this.bookings = new ArrayList<>();
        }
        return bookings;
    }
}
/*@ElementCollection
    @CollectionTable(name = "roomType_count",
            joinColumns = @JoinColumn(name = "hotel_id"))
    @MapKeyColumn(name = "room_type")
    @Column(name = "available_rooms")
    private Map<ROOMTYPE, Integer> roomTypeCount;
    @ElementCollection
    @CollectionTable(name = "roomType_count",
            joinColumns = @JoinColumn(name = "hotel_id"))
    @MapKeyColumn(name = "room_type")
    @Column(name = "room_price")
    private Map<ROOMTYPE, Integer> roomPrices;
    @OneToMany
    @JoinTable(
            name = "hotel_standard_rooms",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> standard = new ArrayList<>();
    @OneToMany
    @JoinTable(
            name = "hotel_deluxe_rooms",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> deluxe = new ArrayList<>();
    @OneToMany
    @JoinTable(
            name = "hotel_suite_rooms",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> suite = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "room_availability",
            joinColumns = @JoinColumn(name = "hotel_id"))
    @MapKeyColumn(name = "room_type")
    @Column(name = "available_rooms")
    private Map<ROOMTYPE, Integer> availability = new HashMap<>();
    @ManyToMany
    @JoinTable(
            name = "on_date_available_rooms",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private Map<LocalDate, List<Room>> availableRooms = new HashMap<>();*/
