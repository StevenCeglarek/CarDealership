package com.dealership.dao;

import com.dealership.model.Car;
import com.dealership.model.CarPlanCustomer;
import com.dealership.model.Finances;
import com.dealership.util.DealershipArrayList;

public interface CarDao {

    public boolean addCar(Car car);
    public int removeCar(int carId);
    public DealershipArrayList<Car> getAllCars() throws Exception;
    public DealershipArrayList<Car> findCarsByCustomerId(int customerId);
    public Car findByMakeAndModel(String makeAndModel);
    public int addCarToCustomer(int carId, int customerId);
    public String getFirstCarsMake();
    public DealershipArrayList<Car> findCarsByCustomerIdOf1();
    public DealershipArrayList<CarPlanCustomer> findPlansWithCarInfo();
}
