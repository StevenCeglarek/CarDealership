package com.dealership.dao;

import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.model.User;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

public interface UserDao {

    public boolean addEmployee(Employee employee);
    public boolean addCustomer(Customer customer);
    public boolean updateUser(User user);
    public Employee findEmployeeByUsername(String username);
    public Customer findCustomerByUsername(String username);
}
