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
    @Column
    protected String id;
    @Column
    protected String name;
    @Column(unique = true)
    protected String email;
    @Column
    protected String phoneNumber;
}
