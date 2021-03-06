package com.dealership.dao;

import com.dealership.model.Car;
import com.dealership.util.DealershipArrayList;

public interface CarDao {

    public boolean addCar(Car car);
    public boolean removeCar();
    public DealershipArrayList<Car> getAllCars();
    public Car findCarByCustomerId();
    public Car findByMakeAndModel(String makeAndModel);
}
