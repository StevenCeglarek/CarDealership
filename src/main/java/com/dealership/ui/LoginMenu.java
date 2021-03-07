package com.dealership.ui;

import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.services.UserService;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu{

    public void displayMenu(Scanner scan) throws Exception {
        UserService us = new UserService();

        System.out.println("Hello, are you logging in as a Employee or an Customer? 1. Employee, 2. Customer");
        boolean continueLoop = true;
        do {
            String EC = scan.nextLine();
            if(EC.equals("1")) {
                System.out.println("Welcome, Please enter username: ");
                String username = scan.nextLine();
                System.out.println("Please enter your password: ");
                String password = scan.nextLine();
                Employee emp = us.findUserByUsernameEmployee(username);
                if(emp == null || !emp.getPassword().equals(password)) {
                    System.out.println("Login Failed");
                } else
                    System.out.println("You will now be redirected to the Employee Menu.");
                    EmployeeMenu empm = new EmployeeMenu(emp);
                    empm.displayMenu(scan);
                continueLoop = false;
            } else if (EC.equals("2")) {
                System.out.println("Welcome, Please enter username: ");
                String username = scan.nextLine();
                System.out.println("Please enter your password: ");
                String password = scan.nextLine();
                Customer cust = us.findUserByUsernameCustomer(username);
                if(cust == null || !cust.getPassword().equals(password)) {
                    System.out.println("Login Failed");
                } else
                    System.out.println("You will now be redirected to the Customer Menu.");
                    CustomerMenu cm = new CustomerMenu(cust);
                    cm.displayMenu(scan);
                    continueLoop = false;
            } else {
                System.out.println("Sorry, you entered the wrong command, please try again");
            }
        } while (continueLoop);

//        System.out.println("username: ");
//        String username = scan.nextLine();
//        System.out.println("password: ");
//        String password = scan.nextLine();
//        Employee emp = new UserService().findUserByUsernameEmployee(username);
//        if (emp == null || !emp.getPassword().equals(password)) {
//            System.out.println("login failed");
//        } else {
//            System.out.println("congratulations, have a great virtual workout");
//            MemberMenu mm = new MemberMenu(emp);
//            mm.showMenu(scan);
    }


}
