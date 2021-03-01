package com.dealership.model;

public class Employee extends User {

    private String employeeNumber;

    public Employee() {}

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
