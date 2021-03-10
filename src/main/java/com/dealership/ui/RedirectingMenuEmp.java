package com.dealership.ui;

import com.dealership.model.Employee;

import java.util.Scanner;

public class RedirectingMenuEmp extends AbstractMenu {

    private Employee employee;
    @Override
    public void displayMenu(Scanner scan) throws Exception {
        EmployeeMenu em = new EmployeeMenu(employee);
        em.displayMenu(scan);
    }

    public RedirectingMenuEmp(){}

    public RedirectingMenuEmp(Employee employee) {
        this.employee = employee;
    }
}
