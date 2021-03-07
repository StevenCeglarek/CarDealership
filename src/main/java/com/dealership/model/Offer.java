package com.dealership.model;


public class Offer {

    private int customerId;
    private int carId;
    private double amountOffered;

    public Offer(double amountOffered) {
        this.amountOffered = amountOffered;
    }

    public Offer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public double getAmountOffered() {
        return amountOffered;
    }

    public void setAmountOffered(double amountOffered) {
        this.amountOffered = amountOffered;
    }

    @Override
    public String toString() {
        return "Offer: " +
                "amountOffered=" + amountOffered ;
    }
}
