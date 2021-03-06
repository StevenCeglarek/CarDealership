package com.dealership.dao;

import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Employee;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDaoImpl implements CarDao{

    Connection connection = null;
    PreparedStatement stmt = null;
    @Override
    public boolean addCar(Car car) {
        try {
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO cars(makeAndModel, year, price)" +
                    "VALUES (?, ?, ?)";

            stmt = connection.prepareStatement(sql);

            stmt.setString(1, car.getMakeAndModel());
            stmt.setString(2, car.getYear());
            stmt.setDouble(3, car.getPrice());

            if (stmt.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean removeCar() {
        return false;
    }

    @Override
    public DealershipArrayList<Car> getAllCars() {
        DealershipArrayList<Car> cars = new DealershipArrayList<>();

        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM cars";
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Car car = new Car();

                car.setMakeAndModel(rs.getString("makeAndModel"));
                car.setYear(rs.getString("year"));
                car.setPrice(rs.getDouble("price"));
                cars.add(car);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return cars;
    }

    @Override
    public Car findCarByCustomerId() {
        return null;
    }

    @Override
    public Car findByMakeAndModel(String makeAndModel) {
        Car car = null;
        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM cars WHERE makeandmodel LIKE ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + makeAndModel + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                car = new Car();

                car.setCarId(rs.getInt("carId"));
                car.setMakeAndModel(rs.getString("makeAndModel"));
                car.setYear(rs.getString("year"));
                car.setPrice(rs.getDouble("price"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeResources();
        }
        return car;
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
