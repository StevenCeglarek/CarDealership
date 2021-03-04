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
    public DealershipList<Employee> getAllEmployees() {
        DealershipList<Employee> employees = new DealershipArrayList<>();

        try {
            connection = DAOUtilities.getConnection();	// Get our database connection from the manager
            String sql = "SELECT * FROM employees";			// Our SQL query
            stmt = connection.prepareStatement(sql);	// Creates the prepared statement from the query

            ResultSet rs = stmt.executeQuery();			// Queries the database

            // So long as the ResultSet actually contains results...
            while (rs.next()) {
                // We need to populate a Book object with info for each row from our query result
                Employee employee = new Employee();

                // Each variable in our Book object maps to a column in a row from our results.
//                Integer id = rs.getInt("employeeId");
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setEmail(rs.getString("email"));
                employee.setEmployee(rs.getBoolean("isEmployee"));

                // Finally we add it to the list of Book objects returned by this query.
                employees.addUser(employee);

            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // We need to make sure our statements and connections are closed,
            // or else we could wind up with a memory leak
            closeResources();
        }

        // return the list of Book objects populated by the DB.
        return employees;
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
