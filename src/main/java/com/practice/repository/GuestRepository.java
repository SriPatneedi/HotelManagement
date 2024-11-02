package com.practice.repository;

import com.practice.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {

    @Query("SELECT g FROM Guest g WHERE g.name = ?1")
    Guest getByName(String name);

    Guest deleteByName(String name);

    //List<Guest> findByNameEmailPhoneNumber(String name, String email, String phoneNumber);
}
