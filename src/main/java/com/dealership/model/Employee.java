package com.dealership.model;

import com.dealership.util.DealershipArrayList;


public class Employee extends User {

    private DealershipArrayList<Car> carsInDealership;
//    private int employeeId;
    private boolean isEmployee;

    public Employee(String username, String password, String phoneNumber, String email) {
        super(username, password, phoneNumber, email);
        this.isEmployee = true;
//        this.employeeId = employeeId;
    }

    public Employee() {}

    public DealershipArrayList<Car> getCarsInDealership() {
        return carsInDealership;
    }

    public void setCarsInDealership(DealershipArrayList<Car> carsInDealership) {
        this.carsInDealership = carsInDealership;
    }

//    public int getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(int employeeId) {
//        this.employeeId = employeeId;
//    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }
}
