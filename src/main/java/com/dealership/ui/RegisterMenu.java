package com.dealership.ui;

import com.dealership.model.User;
import com.dealership.services.UserService;

import java.util.Scanner;

public class RegisterMenu extends AbstractMenu{

    @Override
    public void displayMenu(Scanner scan) {

        UserService us = new UserService();

        System.out.println("Welcome to the Car Dealership Register Menu");
        String username = "";
        // hey something is wrong
        do{
            System.out.println("provide username");
            username = scan.nextLine();
        } while(us.doesUsernameExist(username));
        System.out.println("provide password");
        // TODO: check phone number
        String password = scan.nextLine();
        System.out.println("provide phone number");
        // TODO: check email
        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        System.out.println(us.makeUser(username, password, phoneNumber, email) ?
                "successfully made "+username :
                "cancelled registration");

        }

    public void registerEmployeeOrCustomer(User u, Scanner scan) {
        UserService us = new UserService();
        System.out.println("Are you registering an Employee or a Customer?");
        String answer = scan.nextLine();
        if (answer.equalsIgnoreCase("employee")) {
            System.out.println("Please enter the employee passcode to register as an employee.");
            answer = scan.nextLine();
            us.registerEmployeeOrCustomer(answer, u.getUsername());
        }

    }


}
