package com.practice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@Setter
@Getter
@MappedSuperclass
@Component
public abstract class User {
    @Id
    @Column(name = "id")
    protected String id;
    @Column(name = "name")
    protected String name;
    @Column(name = "email")
    protected String email;
    @Column(name = "phone_number")
    protected String phoneNumber;
}
