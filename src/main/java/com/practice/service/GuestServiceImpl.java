package com.practice.service;

import com.practice.entity.Guest;
import com.practice.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    private GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }


    public List<Guest> findAll(){
        return guestRepository.findAll();
    }

    public Guest add(Guest guest){
        return guestRepository.save(guest);
    }

    public Guest getByName(String name){
        return guestRepository.getByName(name);
    }

    @Transactional
    public Guest getById(String id){
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cant find guest with id."));
        return guest;
    }

    public Boolean existsById(String id){
        return guestRepository.existsById(id);
    }

    public void removeGuest(String id){
        guestRepository.deleteById(id);
    }
}
