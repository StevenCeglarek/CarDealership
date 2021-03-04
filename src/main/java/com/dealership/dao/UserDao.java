package com.dealership.dao;

import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.model.User;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

public interface UserDao {

    public boolean addEmployee(Employee user);
    public boolean addCustomer(Customer user);
    public boolean updateUser(User user);
    public DealershipList<Employee> getAllEmployees();
}
