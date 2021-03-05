package com.dealership.ui;

import com.dealership.model.Employee;
import com.dealership.services.CarService;

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
        }

    }

    public EmployeeMenu(Employee emp) {
        this.emp = emp;
    }
}
