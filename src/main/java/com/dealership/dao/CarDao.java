package com.dealership.dao;

import com.dealership.model.Car;

public interface CarDao {

    public boolean addCar(Car car);
    public Car findCarByName();
    public boolean removeCar();
}
