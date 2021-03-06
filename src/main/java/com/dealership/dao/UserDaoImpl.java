package com.dealership.dao;

import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.model.User;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    Connection connection = null;
    PreparedStatement stmt = null;
    @Override
    public boolean addEmployee(Employee employee) {
        try {
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO employees(username, password, phoneNumber, email, isEmployee) " +
                            "VALUES (?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, employee.getUsername());
            stmt.setString(2, employee.getPassword());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhoneNumber());
            stmt.setBoolean(5, employee.isEmployee());
            if (stmt.executeUpdate() != 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    public boolean addCustomer(Customer customer) {
        try {
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO customers(username, password, phoneNumber, email) " +
                    "VALUES (?, ?, ?, ?)";
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getPassword());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhoneNumber());
            if (stmt.executeUpdate() != 0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeResources();
        }
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public Employee findEmployeeByUsername(String username) {
        Employee employee = null;
        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM employees WHERE username LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + username + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                employee = new Employee();

                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setEmail(rs.getString("email"));
                employee.setEmployee(rs.getBoolean("isEmployee"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResources();
        }
        return employee;
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        Customer customer = null;
        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM customers WHERE username LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + username + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                customer = new Customer();

                customer.setCustomerId(rs.getInt("customerId"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResources();
        }
        return customer;
    }

    @Override
    public Customer findCustomerById(Customer customer) {
        return null;
    }

    @Override
    public Customer findEmployeeById(Employee employee) {
        return null;
    }

    @Override
    public DealershipArrayList<Employee> getAllEmployees() {
        DealershipArrayList<Employee> employees = new DealershipArrayList<>();

        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM employees";
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {

                Employee employee = new Employee();

                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setEmail(rs.getString("email"));
                employee.setEmployee(rs.getBoolean("isEmployee"));

                employees.add(employee);

            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return employees;
    }

    public DealershipArrayList<Customer> getAllCustomers() {
        DealershipArrayList<Customer> customers = new DealershipArrayList<>();

        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM employees";
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return customers;
    }

    private void closeResources() {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            System.out.println("Could not close statement!");
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close connection!");
            e.printStackTrace();
        }
    }


}
