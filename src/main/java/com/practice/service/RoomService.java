package com.practice.service;

import com.practice.entity.Booking;
import com.practice.entity.Hotel;
import com.practice.entity.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface RoomService {
    List<Room> findRooms();
    void createRooms(Set<Room> rooms);
    Room addRoom(Room room);
    void deleteAll();
    Booking bookRooms(int hotelId, String guestId,
                      Hotel.ROOMTYPE type, int noOfRooms,
                      LocalDate checkInDate, LocalDate checkOutDate);

}
