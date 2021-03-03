package com.dealership.model;

import java.util.ArrayList;

public class Employee extends User {

    private String employeeNumber;
    private ArrayList<Car> carsInDealership;

    public Employee(String username, String password, String phoneNumber, String email) {
        super(username, password, phoneNumber, email);
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public ArrayList<Car> getCarsInDealership() {
        return carsInDealership;
    }

    public void setCarsInDealership(ArrayList<Car> carsInDealership) {
        this.carsInDealership = carsInDealership;
    }
}
