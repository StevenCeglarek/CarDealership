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

    public Employee findUserByUsernameEmployee(String username){
        // O(n) time complexity O(1) space complexity
        Employee thisEmp = u.findEmployeeByUsername(username);
        if (thisEmp == null) {
            return null;
        } else {
            return thisEmp;
        }
    }

    public boolean doesUsernameExistCustomer(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsernameCustomer(username) != null;
    }

    public Customer findUserByUsernameCustomer(String username){
        // O(n) time complexity O(1) space complexity

        Customer thisCust = u.findCustomerByUsername(username);
        if (thisCust == null) {
            return null;
        } else {
            return thisCust;
        }
    }

    public boolean makeUserEmployee(String username, String password, String email,
                            String phoneNumber) {
        if(!doesUsernameExistEmployee(username)){
            employeeList.add(new Employee(username, password, phoneNumber, email));
            Employee newEmp = employeeList.get(currentIndexEmployee);
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
            customerList.add(new Customer(username, password, phoneNumber, email));
            Customer newCust = customerList.get(currentIndexCustomer);
            u.addCustomer(newCust);
            currentIndexCustomer++;
            return true;
        } else {
            System.out.println("Customer already exists");
        }
        return false;
    }



}
