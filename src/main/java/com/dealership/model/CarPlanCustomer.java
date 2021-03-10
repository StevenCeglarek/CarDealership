package com.dealership.model;

public class CarPlanCustomer {

    private String username;
    private String makeAndModel;
    private String year;
    private double amountRemaining;
    private double monthlyPayment;
    private int monthsPaid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Owner: " + username +
                ", Make and Model: " + makeAndModel +
                ", Year: " + year +
                ", Amount Remaining: " + amountRemaining +
                ", Monthly Payment: " + monthlyPayment +
                ", Months Paid: " + monthsPaid;
    }
}
