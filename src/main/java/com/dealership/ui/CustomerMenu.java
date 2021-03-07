package com.dealership.ui;

import com.dealership.dao.UserDaoImpl;
import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.services.CarService;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu {

    private Customer cust;

    @Override
    public void displayMenu(Scanner scan) throws Exception {
        CarService cs = new CarService();
        System.out.println("Welcome " + cust.getUsername() + " Where would you like to be redirected?");
        System.out.println("1. View all of the cars on the lot and make an offer on a specific car " +
                "2. View the cars that you currently own 3. View remaining payments on a specific car");
        String answer = scan.nextLine();
        boolean continueLoop = true;
        do {
            if (answer.equals("1")) {
                System.out.println("Here are all of the cars currently on the lot");
                System.out.println(cs.viewsCars());
                System.out.println("Would you like to make an offer for a car on the lot? y/n");
                String answer2 = scan.nextLine();
                if (answer2.equals("y")) {
                    int carNum = 0;
                    do {
//                        TODO: Need to make a check if a customer has already placed an offer on a car for it to be removed from the list of cars
                        System.out.println("Please specify which car you would like to put an offer on");
                        String x = scan.nextLine();
                        carNum = Integer.parseInt(x);
                    } while(carNum > cs.viewsCars().size() || carNum < -1);
                        Car thisCar = cs.viewsCars().get(carNum);
                        System.out.println("How much would you like to offer for the " + thisCar.getYear() + " " + thisCar.getMakeAndModel() +
                                " for " + thisCar.getPrice() + "?");
                        String x = scan.nextLine();
                        Double offer = Double.parseDouble(x);
                        cs.makeOffer(offer, cust.getCustomerId(), thisCar.getCarId());
                        System.out.println("Your offer is now in the Queue, Please check back to see if it will be accepted.");
                        continueLoop = false;
                } else if (answer2.equals("n")) {
                    System.out.println("You will be redirected to the main menu.");
                    continueLoop = false;
                }
            } else if (answer.equals("2")) {
                System.out.println("Here are the cars that you currently own from our dealership");
                System.out.println(cs.viewsCarsByCustomerId(cust.getCustomerId()));
                continueLoop = false;
            }
        } while (continueLoop);
    }

    public CustomerMenu(Customer cust) {
        this.cust = cust;
    }

    public CustomerMenu() {}
}
