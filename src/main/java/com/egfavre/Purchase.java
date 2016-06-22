package com.egfavre;

import javax.persistence.*;

/**
 * Created by user on 6/22/16.
 */
@Entity
@Table (name="purchases")
public class Purchase {
    @GeneratedValue
    @Id
    int id;

    @ManyToOne
    Customer customer;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    int creditCard;

    @Column(nullable = false)
    int cvv;

    @Column(nullable = false)
    String category;

    public Purchase(Customer customer, String date, int creditCard, int cvv, String category) {
        this.customer = customer;
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
    }

    public Purchase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
