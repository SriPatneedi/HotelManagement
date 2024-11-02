package com.practice.repository;

import com.practice.entity.Hotel;
import com.practice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

    List<Room> findByTypeAndHotelIdAndStatus(Hotel.ROOMTYPE type, int hotelId, Room.STATUS status);
}
