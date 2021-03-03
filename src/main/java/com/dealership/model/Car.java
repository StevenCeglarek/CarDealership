package com.dealership.model;

import java.util.ArrayList;

public class Car {

    private String make;
    private String year;
    private Double price;
    private ArrayList<String> payments;

    public Car() {}

    public Car(String make, String year, Double price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<String> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<String> payments) {
        this.payments = payments;
    }

    public String toString() {
        return "Make and Model: " + getMake() + " Year: " + getYear() + " Price: " + getPrice();
    }
}
