package com.dealership.ui;

import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Finances;
import com.dealership.model.Offer;
import com.dealership.services.CarService;
import com.dealership.services.UserService;
import com.dealership.util.DealershipArrayList;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu{

    private Employee emp;
    private DealershipArrayList<Offer> offerList = new DealershipArrayList<>();
    private DealershipArrayList<Car> carList = new DealershipArrayList<>();
    private DealershipArrayList<Finances> financeList = new DealershipArrayList<Finances>();


    @Override
    public void displayMenu(Scanner scan) throws Exception {
        CarService cs = new CarService();
        LoginMenu lm = new LoginMenu();
        UserService us = new UserService();
        RedirectingMenuEmp rm = new RedirectingMenuEmp(emp);
        if (emp == null) {
            lm.displayMenu(scan);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Welcome " + emp.getUsername() + ".");
        System.out.println("1. Add Car to lot");
        System.out.println("2. Remove a car from the lot");
        System.out.println("3. View all the cars on the lot and view offers on a specific car ");
        System.out.println("4. View all payments on all purchase vehicles");
        System.out.println("5. Logout");
        System.out.println("------------------------------------------------------------------");
        String answer = scan.nextLine();
        boolean continueLoop2 = true;
        do {
            if (answer.equals("1")) {
                try {
                    System.out.println("Please enter the Make and Model of the car you want to add");
                    String makeAndModel = scan.nextLine();
                    System.out.println("Please enter the Year of the car");
                    String year = scan.nextLine();
                    System.out.println("Please give the price of the car");
                    String x = scan.nextLine();
                    Double price = Double.parseDouble(x);
                    cs.addCar(makeAndModel, year, price);
                    System.out.println("You have successfully added the " + year + " " + makeAndModel + " for $" + price);
                    continueLoop2 = false;
                    rm.displayMenu(scan);
                } catch (NumberFormatException e) {
                    System.out.println("You have made an invalid entry. Please try again.");
                }
            } else if (answer.equals("2")){
                int carNum = 0;
                do  {
                    System.out.println("Here are all of the cars currently on the lot");
                    carList = cs.viewsCars();
                    System.out.println(carList);
                    System.out.println("Please specify which car you would like to remove from the lot.");
                    String i = scan.nextLine();
                    carNum = Integer.parseInt(i);
                } while (carNum > carList.size() || carNum < -1);
                Car car = carList.get(carNum);
                cs.removeCar(carList.get(carNum).getCarId());
                System.out.println("The " + car.getYear() + " " + car.getMakeAndModel() + " has been removed from the lot.");
                continueLoop2 = false;
                rm.displayMenu(scan);
            } else if (answer.equals("3")) {
                int carNum = 0;
                do  {
                    System.out.println("Here are all of the cars currently on the lot");
                    carList = cs.viewsCars();
                    System.out.println(carList);
                    System.out.println("Please specify which car you would like to view the current offers on");
                    String i = scan.nextLine();
                    carNum = Integer.parseInt(i);
                } while (carNum > carList.size() || carNum < -1);
                Car car = carList.get(carNum);
                offerList = cs.getOffer(car.getCarId());
                if (offerList.size() == 0) {
                    System.out.println("The " + car.getYear() + " " + car.getMakeAndModel() + " currently has no offers placed on it");
                    continueLoop2 = false;
                    rm.displayMenu(scan);
                } else {
                    System.out.println("The current offer(s) for the " + car.getYear() + " " + car.getMakeAndModel() +
                            " are for " + offerList.toString());
                    System.out.println("Please specify which offer you would like to modify.");
                    String x = scan.nextLine();
                    int offerNum = Integer.parseInt(x);
                    Offer offer = offerList.get(offerNum);
                    System.out.println("Would you like to accept or reject the offer, once an offer is accepted, all other " +
                            "offers for this vehicle will be removed.");
                    String aOrR = scan.nextLine();
                    if (aOrR.equals("accept")) {
                        System.out.println("The offer has been accepted and all other offers on this vehicle are now considered rejected.");
                        cs.acceptOffer(offer, car);
                        continueLoop2 = false;
                        rm.displayMenu(scan);
                    } else if (aOrR.equals("reject")) {
                        System.out.println("The offer has been rejected and a message has been sent to the Customer who made the offer.");
                        cs.removeOffer(offer.getCarId(), offer.getCustomerId());
                        continueLoop2 = false;
                        rm.displayMenu(scan);
                    } else {
                        System.out.println("Sorry, you entered the wrong command, please try again");
                        emp = null;
                        continueLoop2 = false;
                        rm.displayMenu(scan);
                    }
                }
            } else if (answer.equals("4")) {
//                TODO: Figure out how to show all of the Owner's information
                financeList = cs.viewAllPlans();
                if (financeList.size() == 0) {
                    System.out.println("There is currently no payment history in the system for any vehicle.");
                    continueLoop2 = false;
                    rm.displayMenu(scan);
                }
                System.out.println("Here is a list of all the cars and their finance plans");
                System.out.println(cs.findPlansWithCarInfo() + "\n---------------------------------------------");
                continueLoop2 = false;
                rm.displayMenu(scan);
            } else if (answer.equals("5")) {
                System.out.println("You are now being logged out.");
                emp = null;
                lm.displayMenu(scan);
                continueLoop2 = false;
            } else {
                System.out.println("Sorry, you entered the wrong command, please try again");
                continueLoop2 = false;
                rm.displayMenu(scan);
            }
        } while (continueLoop2);


    }

    public EmployeeMenu(Employee emp) {
        this.emp = emp;
    }
}
