package com.practice.controller;

import com.practice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService service){
        this.bookingService = service;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable String id){
        try {
            return new ResponseEntity<>(bookingService.getById(id), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}/cancel")
    public ResponseEntity<?> cancelBooking(@PathVariable String id){
        try {
            return new ResponseEntity<>(bookingService.cancelBooking(id), HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
