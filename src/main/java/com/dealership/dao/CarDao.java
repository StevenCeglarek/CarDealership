package com.dealership.dao;

import com.dealership.model.Car;
import com.dealership.util.DealershipList;

public interface CarDao {

    public boolean addCar(Car car);
    public Car findCarByName();
    public boolean removeCar();
    public DealershipList<Car> getAllCars();
    public Car findCarByCustomerId();
    public Car findByMakeAndModel(String makeAndModel);
}
