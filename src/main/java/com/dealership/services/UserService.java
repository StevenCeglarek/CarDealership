package com.dealership.services;

import com.dealership.dao.UserDaoImpl;
import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.model.User;
import com.dealership.util.DealershipArrayList;

public class UserService {

    public static DealershipArrayList<Employee> employeeList = new DealershipArrayList<Employee>();
    public static DealershipArrayList<Customer> customerList = new DealershipArrayList<Customer>();
    private static int currentIndexEmployee = 0;
    private static int currentIndexCustomer = 0;
    UserDaoImpl u = new UserDaoImpl();

    public boolean doesUsernameExistEmployee(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsernameEmployee(username) != null;
    }

    public User findUserByUsernameEmployee(String username){
        // O(n) time complexity O(1) space complexity
        if(currentIndexEmployee > 0) {
            for (int i = 0; i < currentIndexEmployee; i++) {
                User thisUser = (User) employeeList.get(i);
                if (thisUser.getUsername().equals(username)) {
                    return (User) employeeList.get(i);
                }
            }
        }
        return null;
    }

    public boolean doesUsernameExistCustomer(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsernameCustomer(username) != null;
    }

    public User findUserByUsernameCustomer(String username){
        // O(n) time complexity O(1) space complexity

        if(currentIndexCustomer > 0) {
            for (int i = 0; i < currentIndexCustomer; i++) {
                User thisUser = (User) customerList.get(i);
                if (thisUser.getUsername().equals(username)) {
                    return (User) customerList.get(i);
                }
            }
        }
        return null;
    }

    public boolean makeUserEmployee(String username, String password, String email,
                            String phoneNumber) {
        if(!doesUsernameExistEmployee(username)){
            employeeList.addUser(new Employee(username, password, phoneNumber, email));
            Employee newEmp = (Employee) employeeList.get(currentIndexEmployee);
            u.addEmployee(newEmp);
            currentIndexEmployee++;
            return true;
        } else {
            System.out.println("Employee already exists");
        }
        return false;
    }

    public boolean makeUserCustomer(String username, String password, String email,
                            String phoneNumber) {
        if(!doesUsernameExistCustomer(username)){
            customerList.addUser(new Customer(username, password, phoneNumber, email));
            Customer newCust = (Customer) customerList.get(currentIndexCustomer);
            u.addCustomer(newCust);
            currentIndexCustomer++;
            return true;
        } else {
            System.out.println("Customer already exists");
        }
        return false;
    }


}
