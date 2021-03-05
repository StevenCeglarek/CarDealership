package com.dealership.ui;

import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.services.CarService;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu {

    private Customer cust;

    @Override
    public void displayMenu(Scanner scan) {
        CarService cs = new CarService();
        System.out.println("Welcome " + cust.getUsername() + "Where would you like to be redirected?");
        System.out.println("1. View all of the cars on the lot 2. Make an offer on a specific car " +
                "3. View the cars that you currently own 4. view remaining payments on a specific car");
        String answer = scan.nextLine();
        boolean continueLoop = true;
        do {
            if (answer.equals("1")) {
                System.out.println("Here are all of the cars currently on the lot");
                System.out.println(cs.viewsCars());
            } else if (answer.equals("2")) {
                System.out.println("Please choose which car you would like to make an offer for");
                String makeAndModel = scan.nextLine();
                Car thisCar = cs.findCarByMakeAndModel(makeAndModel);
                System.out.println("Do you wish to make an off on the " + thisCar.getYear() + thisCar.getMakeAndModel() +
                        " for " + thisCar.getPrice() + "? y/n");
                String answer2 = scan.nextLine();
                if (answer2.equals("y")) {
                    System.out.println("How much would you like to offer for this vehicle?");
                    Double offer = scan.nextDouble();

                }
            }
        } while (continueLoop);
    }
}
