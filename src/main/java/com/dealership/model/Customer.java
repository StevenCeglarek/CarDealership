package com.dealership.model;

import com.dealership.util.DealershipArrayList;


public class Customer extends User{

    private DealershipArrayList<Car> carsOwned;
    private String offers;
    private Double payments;
    private int customerId;

    public Customer(String username, String password, String email, String phoneNumber) {
        super(username, password, email, phoneNumber);
    }

    public Customer() {}

    public DealershipArrayList<Car> getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(DealershipArrayList<Car> carsOwned) {
        this.carsOwned = carsOwned;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public Double getPayments() {
        return payments;
    }

    public void setPayments(Double payments) {
        this.payments = payments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
