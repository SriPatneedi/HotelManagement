package com.practice.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@MappedSuperclass
public class User {
    @Id
    @Column(name = "id")
    protected String id;
    @Column(name = "name")
    protected String name;
    @Column(name = "email")
    protected String email;
    @Column(name = "phone_number")
    protected String phoneNumber;

    protected User() {
        this.id = UUID.randomUUID().toString();
    }
}
