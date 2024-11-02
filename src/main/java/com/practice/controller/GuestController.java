package com.practice.controller;

import com.practice.entity.Guest;
import com.practice.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/guest")
public class GuestController {
    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(guestService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addGuest(@RequestBody Guest guest){
        try {
            Boolean exists = guestService.existsById(guest.getId());
            if(!exists){
                return new ResponseEntity<>(guestService.add(guest),HttpStatus.OK);
            }
            return ResponseEntity.badRequest().body("Guest with this id already exists");
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("Guest with this details already exists");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed for unknown reason. Please try again!");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try {
            Guest guest = guestService.getById(id);
            return new ResponseEntity<>(guest,HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed for unknown reason. Please try again!");
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteGuest(@PathVariable String id){
        try {
            guestService.removeGuest(id);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}