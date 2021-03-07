package com.dealership.dao;

import com.dealership.model.Car;
import com.dealership.util.DealershipArrayList;

public interface CarDao {

    public boolean addCar(Car car);
    public int removeCar(int carId);
    public DealershipArrayList<Car> getAllCars() throws Exception;
    public DealershipArrayList<Car> findCarsByCustomerId(int customerId);
    public Car findByMakeAndModel(String makeAndModel);
    public int addCarToCustomer(int carId, int customerId);
}
