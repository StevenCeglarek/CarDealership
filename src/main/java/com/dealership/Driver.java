package com.dealership;

import com.dealership.model.User;
import com.dealership.services.UserService;
import com.dealership.ui.LoginMenu;
import com.dealership.ui.RegisterMenu;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        RegisterMenu rm = new RegisterMenu();
        LoginMenu lm = new LoginMenu();
        Scanner scan = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            System.out.println("Welcome to the car Dealership, Would you like to sign up, login or exit?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("exit")){
                continueLoop = false;
            } else if(answer.equalsIgnoreCase("sign up")) {
                rm.displayMenu(scan);
            } else if(answer.equalsIgnoreCase("login")) {
                lm.displayMenu(scan);
            }
        } while(continueLoop);

    }
}
