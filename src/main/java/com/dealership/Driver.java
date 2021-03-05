package com.dealership;

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

    public static void main(String[] args) {

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

//        UserDaoImpl usd = new UserDaoImpl();
//
//        System.out.println(usd.getAllEmployees().toString());

//        DealershipArrayList<Car> carList = new DealershipArrayList<>();
//        carList.addCar(new Car("Honda Civic", "2021", 30000.00));
//        carList.addCar(new Car("Honda Accord", "2021", 35000.00));
//        carList.addCar(new Car("Honda Civic Type R", "2021", 49000.00));
//        DealershipArrayList<User> userList = new DealershipArrayList<>();
//        userList.addUser(new Employee("Steven", "123456", "1234567", "123@123.com"));
//        userList.addUser(new Employee("bob", "123456", "1234567", "123@123.com"));
//        userList.addUser(new Employee("james", "123456", "1234567", "123@123.com"));
//
//        carList.removeCar((Car) carList.get(0));
//
//        userList.removeUser((User) userList.get(0));
//
//        System.out.println(carList.get(0));
//        System.out.println(carList.get(1));
//        System.out.println(userList.get(0));
//        System.out.println(userList.get(1));




    }
}
