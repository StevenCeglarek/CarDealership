package com.dealership.model;

import java.util.ArrayList;

public class Customer extends User{

    private User u;
    private ArrayList<Car> carsOwned;
    private ArrayList<String> offers;
    private String payments;

    public Customer(User u, ArrayList<Car> carsOwned, ArrayList<String> offers) {
        this.u = u;
        this.carsOwned = carsOwned;
        this.offers = offers;
    }

    public Customer() {}

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

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

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }
}
