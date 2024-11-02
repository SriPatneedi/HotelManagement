package com.practice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Data
@Entity
@Table(name = "ROOM",
        uniqueConstraints = @UniqueConstraint(columnNames =
                {"roomNo", "hotel_id"})
)
@Component
public class Room {
    public enum STATUS {
        AVAILABLE, RESERVED, CONFIRMED
    }
    @Id
    private String id;
    @Column
    private int roomNo;
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonBackReference
    private Hotel hotel;
    @Column
    private Hotel.ROOMTYPE type;
    @Column
    private int price;
    @Column
    private STATUS status;

    /**
     * Room constructor.
     */
    public Room() {
        this.id = UUID.randomUUID().toString();
    }
}
