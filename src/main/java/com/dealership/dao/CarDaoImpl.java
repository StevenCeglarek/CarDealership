package com.dealership.dao;

import com.dealership.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarDaoImpl implements CarDao{

    Connection connection = null;
    PreparedStatement stmt = null;
    @Override
    public boolean addCar(Car car) {
        return false;
    }

    @Override
    public Car findCarByName() {
        return null;
    }

    @Override
    public boolean removeCar() {
        return false;
    }
}
