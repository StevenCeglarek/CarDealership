package com.dealership.services;

import com.dealership.dao.CarDaoImpl;
import com.dealership.dao.OfferDaoImpl;
import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;
import com.dealership.util.DealershipList;

public class CarService {

    public static DealershipArrayList<Car> carList = new DealershipArrayList<>();
    public DealershipArrayList<Car> carsOnLot = new DealershipArrayList<>();
    DealershipArrayList<Offer> offerlist = new DealershipArrayList<>();
    private static int currentCarIndex = 0;
    CarDaoImpl cdi = new CarDaoImpl();
    OfferDaoImpl odi = new OfferDaoImpl();

    public boolean addCar(String makeAndModel, String year, double price) {
        carList.add(new Car(makeAndModel, year, price));
        Car newCar = carList.get(currentCarIndex);
        currentCarIndex++;
        cdi.addCar(newCar);

        return true;
    }

    public DealershipArrayList<Car> viewsCars() {
        carsOnLot = cdi.getAllCars();
        return carsOnLot;
    }

    public Car findCarByMakeAndModel(String makeAndModel) {
        Car car = cdi.findByMakeAndModel(makeAndModel);
        return car;
    }

    public boolean makeOffer(double offerAmount, int customerId, int carId) {
        odi.addOffer(offerAmount, customerId, carId);
        return true;
    }

    public DealershipArrayList<Offer> getOffer(int carId) {
        offerlist = odi.viewOffersByCarId(carId);
        return offerlist;
    }

    public boolean removeOffer(int carId) {
        odi.removeOffer(carId);
        return true;
    }
}
