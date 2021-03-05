package com.dealership.services;

import com.dealership.dao.CarDaoImpl;
import com.dealership.model.Car;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

public class CarService {

    public static DealershipList<Car> carList = new DealershipArrayList<>();
    public DealershipList<Car> carsOnLot = new DealershipArrayList<>();
    private static int currentCarIndex = 0;
    CarDaoImpl cdi = new CarDaoImpl();

    public boolean addCar(String makeAndModel, String year, double price) {
        carList.addCar(new Car(makeAndModel, year, price));
        Car newCar = carList.get(currentCarIndex);
        currentCarIndex++;
        cdi.addCar(newCar);

        return true;
    }

    public DealershipList<Car> viewsCars() {
        carsOnLot = cdi.getAllCars();
        return carsOnLot;
    }

    public Car findCarByMakeAndModel(String makeAndModel) {
        Car car = cdi.findByMakeAndModel(makeAndModel);
        return car;
    }
}
