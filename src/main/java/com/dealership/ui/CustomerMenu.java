package com.dealership.ui;

import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Finances;
import com.dealership.services.CarService;
import com.dealership.services.UserService;
import com.dealership.util.DealershipArrayList;

import java.util.Scanner;

public class CustomerMenu extends AbstractMenu {

    private Customer cust;
    private DealershipArrayList<Car> carList = new DealershipArrayList<>();

    @Override
    public void displayMenu(Scanner scan) throws Exception {
        CarService cs = new CarService();
        UserService us = new UserService();
        LoginMenu lm = new LoginMenu();
        RedirectingMenuCust rm = new RedirectingMenuCust(cust);
        if (cust == null) {
            lm.displayMenu(scan);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Welcome " + cust.getUsername() + ".");
        System.out.println("1. View all of the cars on the lot and make an offer on a specific car ");
        System.out.println("2. View the cars that you currently own and check the balance and/or make a payment");
        System.out.println("3. Logout");
        System.out.println("------------------------------------------------------------------");
        String answer = scan.nextLine();
        boolean continueLoop = true;
        do {
            if (answer.equals("1")) {
                try {
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
                        String str = cs.makeOffer(offer, cust.getCustomerId(), thisCar.getCarId());
                        System.out.println(str);
                        continueLoop = false;
                        cust = null;
                        rm.displayMenu(scan);
                    } else if (answer2.equals("n")) {
                        System.out.println("You will be redirected to the main menu.");
                        continueLoop = false;
                        cust = null;
                        rm.displayMenu(scan);
                    }
                } catch(NumberFormatException e) {
                    System.out.println("You have made an invalid entry. Please try again.");
                }
            } else if (answer.equals("2")) {
                carList = cs.viewsCarsByCustomerId(cust.getCustomerId());
                if (carList.size() == 0) {
                    System.out.println("You currently don't own any vehicles. You will be redirected back to main menu.");
                    continueLoop = false;
                    rm.displayMenu(scan);
                }
                int carNum = 0;
                do  {
                    System.out.println("Here are the cars that you currently own from our dealership");
                    System.out.println(carList);
                    System.out.println("Choose a car to view your remaining balance on the car and to view your monthly payments");
                    String i = scan.nextLine();
                    carNum = Integer.parseInt(i);
                } while (carNum > carList.size() || carNum < -1);
                Finances finance = cs.viewFinancesById(cust.getCustomerId(), carList.get(carNum).getCarId());
                System.out.println(finance);
                System.out.println("Would you like to make a payment? y/n");
                String makePayment = scan.nextLine();
                if (makePayment.equals(("y"))) {
                    finance = cs.makePayment(finance);
                    System.out.println("You have now made a payment of $" + finance.getMonthlyPayment());
                    System.out.println("and you have now paid " + finance.getMonthsPaid() + " month(s)");
                    System.out.println(" and your end balances is now $" + finance.getAmountRemaining());
                    continueLoop = false;
                    rm.displayMenu(scan);
                } else {
                    System.out.println("You will now be redirected back to the main menu");
                    continueLoop = false;
                    rm.displayMenu(scan);
                }
            } else if(answer.equals("3")) {
                System.out.println("You will now be logged out. Thank you for visiting the Car Dealership");
                cust = null;
                lm.displayMenu(scan);
                continueLoop = false;
            }
            else {
                System.out.println("Please enter a valid number selection.");
                continueLoop = false;
                rm.displayMenu(scan);
            }
        } while (continueLoop);
    }

    public CustomerMenu(Customer cust) {
        this.cust = cust;
    }
}
