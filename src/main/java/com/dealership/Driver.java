package com.dealership;

import com.dealership.dao.CarDaoImpl;
import com.dealership.dao.UserDaoImpl;
import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.User;
import com.dealership.ui.LoginMenu;
import com.dealership.ui.RegisterMenu;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

import java.util.Scanner;

public class Driver {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        RegisterMenu rm = new RegisterMenu();
        LoginMenu lm = new LoginMenu();
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
