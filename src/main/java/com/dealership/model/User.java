package com.dealership.model;

import java.util.List;

public class User {

    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String employeeNumber;
    private boolean isEmployee;
    private boolean isCustomer;
    private String offer;
    private List<Object> carsOwned;
    private String payments;

    public User() {

    }

    public User(boolean isEmployee, boolean isCustomer
            , String offer, List<Object> carsOwned, String payments) {
        this.isEmployee = isEmployee;
        this.isCustomer = isCustomer;
        this.offer = offer;
        this.carsOwned = carsOwned;
        this.payments = payments;
    }

    public User(boolean isEmployee, boolean isCustomer
            , String offer, List<Object> carsOwned, String payments, String employeeNumber) {
        this.isEmployee = isEmployee;
        this.isCustomer = isCustomer;
        this.offer = offer;
        this.carsOwned = carsOwned;
        this.payments = payments;
        this.employeeNumber = employeeNumber;
    }

    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setCustomer(boolean customer) {
        isCustomer = customer;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public List<Object> getCarsOwned() {
        return carsOwned;
    }

    public void setCarsOwned(List<Object> carsOwned) {
        this.carsOwned = carsOwned;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }
}
