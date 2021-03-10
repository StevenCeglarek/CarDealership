package com.dealership.ui;

import com.dealership.model.Customer;

import java.util.Scanner;

public class RedirectingMenuCust extends AbstractMenu{
    private Customer customer;
    @Override
    public void displayMenu(Scanner scan) throws Exception {
        CustomerMenu cm = new CustomerMenu(customer);
        cm.displayMenu(scan);
    }

    public RedirectingMenuCust(){}

    public RedirectingMenuCust(Customer customer) {
        this.customer = customer;
    }
}
