package com.dealership.dao;

import com.dealership.jdbc.ConnectionSession;
import com.dealership.model.Car;
import com.dealership.util.DealershipArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDaoImpl implements CarDao{

    @Override
    public boolean addCar(Car car) {
        String sql = "INSERT INTO cars(makeAndModel, year, price)" +
                "VALUES (?, ?, ?)";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {

            ps.setString(1, car.getMakeAndModel());
            ps.setString(2, car.getYear());
            ps.setDouble(3, car.getPrice());

            if (ps.executeUpdate() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//          finally {
//            closeResources();
//        }
        return false;
    }

    @Override
    public int removeCar(int carId) {
        String sql = "DELETE FROM cars where carId = " + carId;
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public DealershipArrayList<Car> getAllCars() {
        DealershipArrayList<Car> cars = new DealershipArrayList<>();
        String sql = "SELECT * FROM cars WHERE NOT (customerId IS NOT NULL);";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Car car = new Car();

                car.setCarId(rs.getInt("carId"));
                car.setMakeAndModel(rs.getString("makeAndModel"));
                car.setYear(rs.getString("year"));
                car.setPrice(rs.getDouble("price"));
                cars.add(car);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public DealershipArrayList<Car> findCarsByCustomerId(int customerId) {
        DealershipArrayList<Car> cars = new DealershipArrayList<>();
        String sql = "SELECT * FROM cars WHERE (customerId = ?);";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Car car = new Car();

                car.setCarId(rs.getInt("carId"));
                car.setMakeAndModel(rs.getString("makeAndModel"));
                car.setYear(rs.getString("year"));
                car.setPrice(rs.getDouble("price"));
                cars.add(car);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car findByMakeAndModel(String makeAndModel) {
        Car car = null;
        String sql = "SELECT * FROM cars WHERE makeandmodel LIKE ?";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ps.setString(1, "%" + makeAndModel + "%");

            ResultSet rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public int addCarToCustomer(int carId, int customerId) {
        String sql = "UPDATE cars SET customerid = " + customerId + " WHERE carId = " + carId;
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            int i = ps.executeUpdate();
//            System.out.println(i + " rows were updated");
            return i;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
