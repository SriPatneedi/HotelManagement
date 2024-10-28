package com.practice.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Component
public class Admin extends User {

    public Admin() {
        this.id = UUID.randomUUID().toString();
    }
}
