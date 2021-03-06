package com.dealership.model;


public class Offer {

    private double amountOffered;

    public Offer(double amountOffered) {
        this.amountOffered = amountOffered;
    }

    public Offer() {}


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
