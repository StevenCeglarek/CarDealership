package com.dealership.model;

import java.util.ArrayList;

public class Car {

    private String makeAndModel;
    private String year;
    private Double price;
    private int carId;
    private ArrayList<String> payments;

    public Car() {}

    public Car(String makeAndModel, String year, Double price) {
        this.makeAndModel = makeAndModel;
        this.year = year;
        this.price = price;
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }

    public void setMakeAndModel(String makeAndModel) {
        this.makeAndModel = makeAndModel;
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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public ArrayList<String> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<String> payments) {
        this.payments = payments;
    }

    public String toString() {
        return "Make and Model: " + getMakeAndModel() + " Year: " + getYear() + " Purchase Price: " + getPrice();
    }
}
