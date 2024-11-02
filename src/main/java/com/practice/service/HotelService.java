package com.practice.service;

import com.practice.entity.Hotel;
import com.practice.entity.Room;

import java.util.List;

public interface HotelService {
    List<Hotel> getBy(String name,
                      String location);
    Hotel getById(int id);
    Hotel addHotel(Hotel hotel);
    List<Room> getRooms(int id, Hotel.ROOMTYPE type);
    void deleteById(int id);
    void deleteAll();


}
