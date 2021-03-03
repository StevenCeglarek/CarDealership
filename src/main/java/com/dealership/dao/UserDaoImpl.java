package com.dealership.dao;

import com.dealership.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    Connection connection = null;
    PreparedStatement stmt = null;
    @Override
    public boolean addUser(User user) {
        try {
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO users VALUES (?, ?, ?, ?)"; // Were using a lot of ?'s here...
            stmt = connection.prepareStatement(sql);

            // But that's okay, we can set them all before we execute
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhoneNumber());
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
