package com.dealership.services;

import com.dealership.dao.CarDaoImpl;
import com.dealership.dao.OfferDaoImpl;
import com.dealership.dao.UserDaoImpl;
import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;

public class CarService {

    public static DealershipArrayList<Car> carList = new DealershipArrayList<>();
    public DealershipArrayList<Car> theseCars = new DealershipArrayList<>();
    DealershipArrayList<Offer> offerlist = new DealershipArrayList<>();
    private static int currentCarIndex = 0;
    CarDaoImpl cdi = new CarDaoImpl();
    OfferDaoImpl odi = new OfferDaoImpl();
    UserDaoImpl udi = new UserDaoImpl();

    public boolean addCar(String makeAndModel, String year, double price) {
        carList.add(new Car(makeAndModel, year, price));
        Car newCar = carList.get(currentCarIndex);
        currentCarIndex++;
        cdi.addCar(newCar);

        return true;
    }

    public DealershipArrayList<Car> viewsCars(){
        theseCars = cdi.getAllCars();
        return theseCars;
    }

    public DealershipArrayList<Car> viewsCarsByCustomerId(int customerId){
        theseCars = cdi.findCarsByCustomerId(customerId);
        return theseCars;
    }

    public Car findCarByMakeAndModel(String makeAndModel) {
        Car car = cdi.findByMakeAndModel(makeAndModel);
        return car;
    }

    public boolean makeOffer(double offerAmount, int customerId, int carId) {
        odi.addOffer(offerAmount, customerId, carId);
        return true;
    }

    public boolean removeCar(int carId) {
        cdi.removeCar(carId);
        return true;
    }

    public DealershipArrayList<Offer> getOffer(int carId) {
        offerlist = odi.viewOffersByCarId(carId);
        return offerlist;
    }

    public boolean removeOffer(int carId, int customerId) {
        odi.removeOffer(carId, customerId);
        return true;
    }

    public boolean acceptOffer(int carId, int customerId) {
        odi.acceptOffer(carId);
        cdi.addCarToCustomer(carId, customerId);
        return true;
    }


}
