package com.practice.repository;

import com.practice.entity.Hotel;
import com.practice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {
    Hotel getByName(String name);
    Hotel deleteByName(String name);


    @Query("SELECT r FROM Room r WHERE (:type IS NULL OR r.type = :type) " +
            "AND r.status = 'AVAILABLE'")
    List<Room> findAvailableRooms(@Param("type") Hotel.ROOMTYPE type);
}
