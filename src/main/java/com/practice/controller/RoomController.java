package com.practice.controller;

import com.practice.entity.Hotel;
import com.practice.entity.Room;
import com.practice.service.RoomService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Set;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService service){
        this.roomService = service;
    }

    @GetMapping
    public ResponseEntity<?> getRooms(){
            try{
                return new ResponseEntity<>(roomService.findRooms(), HttpStatus.OK);
            } catch(Exception e){
                return ResponseEntity.badRequest().build();
            }
    }

    @PostMapping
    public ResponseEntity<?> createRooms(@RequestBody Set<Room> rooms){
            try{
                roomService.createRooms(rooms);
                return ResponseEntity.ok().build();
            } catch (DataIntegrityViolationException e){
                return ResponseEntity.badRequest().body("Please check that you have provided the entire room details.");
            } catch (Exception e){
                return ResponseEntity.badRequest().body("Request failed for unknown reason. Please try again!");
            }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        try {
            roomService.deleteAll();
            return ResponseEntity.ok().build();
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ResponseEntity<?> bookRooms(@RequestParam("hotelId") int hotelID,
                                       @RequestParam("guestId") String guestID,
                                       @RequestParam("roomType") Hotel.ROOMTYPE type,
                                       @RequestParam("noOfRooms") int noOfRooms,
                                       @RequestParam("checkInDate") Date checkInDate,
                                       @RequestParam("checkOutDate") Date checkOutDate) {
        try {
            return new ResponseEntity<>(
                    roomService.bookRooms(
                            hotelID,
                            guestID,
                            type,
                            noOfRooms,
                            checkInDate.toLocalDate(),
                            checkOutDate.toLocalDate()),
                    HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
