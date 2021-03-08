package com.dealership.model;

public class Finances {

    private int carId;
    private int customerId;
    private double amountRemaining;
    private double monthlyPayment;
    private int monthsPaid;

    public Finances(int carId, int customerId, double amountRemaining) {
        this.carId = carId;
        this.customerId = customerId;
        this.amountRemaining = amountRemaining;
    }

    public Finances() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getMonthsPaid() {
        return monthsPaid;
    }

    public void setMonthsPaid(int monthsPaid) {
        this.monthsPaid = monthsPaid;
    }

    public String toString() {
        return "Amount remaining: $" + getAmountRemaining() + " Monthly payment: $" + Math.round(getMonthlyPayment()*100)/100
                + " Months Paid: " + getMonthsPaid();
    }
}
