package com.practice.controller;

import com.practice.entity.Hotel;
import com.practice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<?> getByCriteria(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String location){

        return new ResponseEntity<>(hotelService.getBy(name,location), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addHotel(@RequestBody Hotel hotel){
        try {
            return new ResponseEntity<>(hotelService.addHotel(hotel),HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        try {
            return new ResponseEntity<>(hotelService.getById(id),HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}/rooms")
    public ResponseEntity<?> getRooms(@PathVariable int id, @RequestParam(required = false) Hotel.ROOMTYPE type){
        try {
            return new ResponseEntity<>(hotelService.getRooms(id,type), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        try {
            hotelService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 if deletion is successful
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        try {
            hotelService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 if deletion is successful
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
