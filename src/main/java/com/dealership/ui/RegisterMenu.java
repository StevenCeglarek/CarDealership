package com.dealership.ui;

import com.dealership.services.UserService;

import java.util.Scanner;

public class RegisterMenu extends AbstractMenu {

    public void displayMenu(Scanner scan) {

        UserService us = new UserService();

        System.out.println("Welcome to the Car Dealership Register Menu");
        String username = "";
        do{
            System.out.println("provide username");
            username = scan.nextLine();
        } while(us.doesUsernameExistEmployee(username) || us.doesUsernameExistCustomer(username));
        System.out.println("provide password");
        // TODO: check phone number
        String password = scan.nextLine();
        System.out.println("provide phone number");
        // TODO: check email
        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        System.out.println("Are you registering as an Employee or a Customer? 1. Employee 2. Customer");
        boolean continueLoop = true;
        do {
            String EC = scan.nextLine();
            if(EC.equals("1")) {
                System.out.println("Congratulations, you are now registered as an Employee.");
                System.out.println(us.makeUserEmployee(username, password, phoneNumber, email) ?
                        "Successfully made employee "+username :
                        "cancelled registration");
                continueLoop = false;
            } else if (EC.equals("2")) {
                System.out.println("Congratulations, you are now registered as an Customer.");
                System.out.println(us.makeUserCustomer(username, password, phoneNumber, email) ?
                        "Successfully made customer "+username :
                        "cancelled registration");
                continueLoop = false;
            } else {
                System.out.println("Sorry, you entered the wrong command, please try again");
            }
        } while (continueLoop);

        }



}
