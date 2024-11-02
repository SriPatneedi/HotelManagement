package com.practice.service;

import com.practice.entity.Booking;
import com.practice.entity.Hotel;
import com.practice.entity.Room;
import com.practice.exception.BookingException;
import com.practice.repository.BookingRepository;
import com.practice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;
    private BookingRepository bookingRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository repository, BookingRepository bookingRepository){
        this.roomRepository = repository;
        this.bookingRepository = bookingRepository;
    }

    public List<Room> findRooms(){
        return roomRepository.findAll();
    }

    public void createRooms(Set<Room> rooms){
        roomRepository.saveAll(rooms);
    }

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }


    public Booking bookRooms(int hotelId, String guestId,
                             Hotel.ROOMTYPE type, int noOfRooms,
                             LocalDate checkInDate, LocalDate checkOutDate){
        int noOfDays = (int)ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        int amount = 0;
        if (noOfDays <= 0){
            throw new BookingException("no of days should be positive.");
        }
        if(checkInDate.isBefore(LocalDate.now()) || (checkOutDate.isBefore(checkInDate))){
            throw new BookingException("Invalid Date! Date should be in future.");
        }

        List<Room> roomList = roomRepository.findByTypeAndHotelIdAndStatus(type,hotelId, Room.STATUS.AVAILABLE);
        if(roomList != null && roomList.size() >= noOfRooms){
            amount = (roomList.get(0).getPrice() * noOfRooms) * noOfDays;
        }
        List<String> bookedRooms = new ArrayList<>();
        for(int i = 0; i < noOfRooms; i++){
            Room room = roomList.get(i);
            room.setStatus(Room.STATUS.RESERVED);
            bookedRooms.add(room.getId());
        }
        Booking booking = new Booking(hotelId, guestId , amount, checkInDate, checkOutDate, bookedRooms, Booking.BOOKINGSTATUS.ONHOLD);
        bookingRepository.save(booking);

        return booking;
    }

    public void deleteAll(){
        roomRepository.deleteAll();
    }

}
