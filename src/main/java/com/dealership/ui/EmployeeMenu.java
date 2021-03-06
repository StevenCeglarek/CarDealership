package com.dealership.ui;

import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.services.CarService;
import com.dealership.util.DealershipArrayList;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu{

    private Employee emp;


    @Override
    public void displayMenu(Scanner scan) {
        CarService cs = new CarService();
        System.out.println("Welcome " + emp.getUsername() + ". Where would you like to be redirected?");
        System.out.println("1. Add Car to lot, 2. Remove a car from the lot, 3. View all the cars on the lot" +
                " 4. View offers on a car 5. View all remaining payments on a car");
        String answer = scan.nextLine();
        if (answer.equals("1")) {
            System.out.println("Please enter the Make and Model of the car you want to add");
            String makeAndModel = scan.nextLine();
            System.out.println("Please enter the Year of the car");
            String year = scan.nextLine();
            System.out.println("Please give the price of the car");
            Double price = scan.nextDouble();
            cs.addCar(makeAndModel, year, price);
            System.out.println("You have successfully added the " + year + " " + makeAndModel + " for $" + price);
        } else if (answer.equals("3")) {
            System.out.println("Here are all of the cars currently on the lot");
            System.out.println(cs.viewsCars());
        } else if (answer.equals("4")) {
            System.out.println("Please specify which car you would like to view the current offers on");
            String makeAndModel = scan.nextLine();
            Car car = cs.findCarByMakeAndModel(makeAndModel);
            DealershipArrayList<Offer> offerList = cs.getOffer(car.getCarId());
            System.out.println("The current offer(s) for the " + car.getYear() + " " + car.getMakeAndModel() +
                    " are for " + offerList.toString());
            System.out.println("Would you like to accept or reject an offer, once an offer is accepted, all other offers are removed.");
            String aOrR = scan.nextLine();
            if (aOrR.equals("accept")) {
                System.out.println("Please specify which offer you would like to accept by giving the number next to the offer.");
                int offerNum = scan.nextInt();
                offerList.get(offerNum);
                System.out.println("The offer has been accepted and a message has been sent to the Customer who made the offer.");
            } else if (aOrR.equals("reject")) {
                System.out.println("Please specify which offer you would like to reject by giving the number next to the offer.");
                int offerNum = scan.nextInt();
                offerList.get(offerNum);
                System.out.println("The offer has been rejected and a message has been sent to the Customer who made the offer.");
            } else {
                System.out.println("Sorry, you entered the wrong command, please try again");
            }
        }

    }

    public EmployeeMenu(Employee emp) {
        this.emp = emp;
    }
}
