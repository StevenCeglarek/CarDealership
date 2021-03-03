package com.dealership.model;

import java.util.ArrayList;

public class Customer extends User{

    private ArrayList<Car> carsOwned;
    private ArrayList<String> offers;
    private Double payments;

    public Customer(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }

    public Customer() {}

    public ArrayList<Car> getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(ArrayList<Car> carsOwned) {
        this.carsOwned = carsOwned;
    }

    public ArrayList<String> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<String> offers) {
        this.offers = offers;
    }

    public Double getPayments() {
        return payments;
    }

    public void setPayments(Double payments) {
        this.payments = payments;
    }
}
