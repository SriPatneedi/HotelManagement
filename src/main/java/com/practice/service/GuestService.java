package com.practice.service;

import com.practice.entity.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuestService {
    public List<Guest> findAll();
    Guest add(Guest guest);
    Guest getById(String id);
    Boolean existsById(String id);
    Guest getByName(String name);
    void removeGuest(String id);
}
