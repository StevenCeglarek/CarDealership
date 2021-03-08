package com.dealership.ui;

import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.services.CarService;
import com.dealership.util.DealershipArrayList;

import java.util.Scanner;

public class EmployeeMenu extends AbstractMenu{

    private Employee emp;
    private DealershipArrayList<Offer> offerList = new DealershipArrayList<>();
    private DealershipArrayList<Car> carList = new DealershipArrayList<>();


    @Override
    public void displayMenu(Scanner scan) {
        CarService cs = new CarService();
        System.out.println("Welcome " + emp.getUsername() + ". Where would you like to be redirected?");
        System.out.println("1. Add Car to lot, 2. Remove a car from the lot, 3. View all the cars on the lot " +
                "and view offers on a specific car 4. View all remaining payments on a car");
        String answer = scan.nextLine();
        boolean continueLoop2 = true;
        do {
            if (answer.equals("1")) {
                System.out.println("Please enter the Make and Model of the car you want to add");
                String makeAndModel = scan.nextLine();
                System.out.println("Please enter the Year of the car");
                String year = scan.nextLine();
                System.out.println("Please give the price of the car");
                Double price = scan.nextDouble();
                cs.addCar(makeAndModel, year, price);
                System.out.println("You have successfully added the " + year + " " + makeAndModel + " for $" + price);
                continueLoop2 = false;
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
                } else {
//                TODO: Make a check for if there are no offers on the car
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
                    } else if (aOrR.equals("reject")) {
                        System.out.println("The offer has been rejected and a message has been sent to the Customer who made the offer.");
                        System.out.println(offer.getCarId());
                        System.out.println(offer.getCustomerId());
                        cs.removeOffer(offer.getCarId(), offer.getCustomerId());
                        continueLoop2 = false;
                    } else {
                        System.out.println("Sorry, you entered the wrong command, please try again");
                    }
                }
            } else if (answer.equals("4")) {

            } else {
                System.out.println("Sorry, you entered the wrong command, please try again");
            }
        } while (continueLoop2);


    }

    public EmployeeMenu(Employee emp) {
        this.emp = emp;
    }
}
