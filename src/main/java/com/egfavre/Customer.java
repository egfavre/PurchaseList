package com.egfavre;

import javax.persistence.*;

/**
 * Created by user on 6/22/16.
 */
@Entity
@Table(name="customers")
public class Customer {
    @GeneratedValue
    @Id
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
