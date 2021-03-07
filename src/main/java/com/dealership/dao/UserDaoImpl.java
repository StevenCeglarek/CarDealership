package com.dealership.dao;

import com.dealership.jdbc.ConnectionSession;
import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.model.User;
import com.dealership.util.DealershipArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    Connection connection = null;
    PreparedStatement stmt = null;
    @Override
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees(username, password, phoneNumber, email) " +
                "VALUES (?, ?, ?, ?)";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
         {

            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhoneNumber());
            if (ps.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers(username, password, phoneNumber, email) " +
                "VALUES (?, ?, ?, ?)";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
         {

            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhoneNumber());
            if (ps.executeUpdate() != 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public Employee findEmployeeByUsername(String username) {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE username LIKE ?";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
         {
            ps.setString(1, "%" + username + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employee = new Employee();

                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        Customer customer = null;
        String sql = "SELECT * FROM customers WHERE username LIKE ?";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ps.setString(1, "%" + username + "%");

            ResultSet rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public DealershipArrayList<Employee> getAllEmployees() {
        DealershipArrayList<Employee> employees = new DealershipArrayList<>();
        String sql = "SELECT * FROM employees";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

                Employee employee = new Employee();

                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setEmail(rs.getString("email"));
                employees.add(employee);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public DealershipArrayList<Customer> getAllCustomers() {
        DealershipArrayList<Customer> customers = new DealershipArrayList<>();
        String sql = "SELECT * FROM customers";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }


}
