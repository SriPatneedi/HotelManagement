package com.practice.entity;

import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "ADMIN")
public class Admin extends User {

    /**
     * Constructor for creating Admin.
     * @param name admin name
     * @param email admin email
     * @param contactNumber admin contact number
     */
    public Admin(final String name, final String email,
                 final String contactNumber) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = contactNumber;
    }
}
