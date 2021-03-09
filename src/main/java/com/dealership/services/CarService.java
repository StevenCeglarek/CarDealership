package com.dealership.services;

import com.dealership.dao.CarDaoImpl;
import com.dealership.dao.FinancesDaoImpl;
import com.dealership.dao.OfferDaoImpl;
import com.dealership.dao.UserDaoImpl;
import com.dealership.model.Car;
import com.dealership.model.Finances;
import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;

public class CarService {

    public static DealershipArrayList<Car> carList = new DealershipArrayList<>();
    public DealershipArrayList<Car> theseCars = new DealershipArrayList<>();
    public DealershipArrayList<Offer> offerlist = new DealershipArrayList<>();
    public DealershipArrayList<Finances> financeList = new DealershipArrayList<>();
    private static int currentCarIndex = 0;
    CarDaoImpl cdi = new CarDaoImpl();
    OfferDaoImpl odi = new OfferDaoImpl();
    UserDaoImpl udi = new UserDaoImpl();
    FinancesDaoImpl fdi = new FinancesDaoImpl();

    public void addCar(String makeAndModel, String year, double price) {
        carList.add(new Car(makeAndModel, year, price));
        Car newCar = carList.get(currentCarIndex);
        currentCarIndex++;
        cdi.addCar(newCar);

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

    public void makeOffer(double offerAmount, int customerId, int carId) {
        odi.addOffer(offerAmount, customerId, carId);
    }

    public void removeCar(int carId) {
        cdi.removeCar(carId);
    }

    public DealershipArrayList<Offer> getOffer(int carId) {
        offerlist = odi.viewOffersByCarId(carId);
        return offerlist;
    }

    public void removeOffer(int carId, int customerId) {
        odi.removeOffer(carId, customerId);
    }

    public void acceptOffer(Offer offer, Car car) {
        odi.acceptOffer(offer.getCarId());
        cdi.addCarToCustomer(offer.getCarId(), offer.getCustomerId());
        double amountRemaining = car.getPrice() - offer.getAmountOffered();
        double monthlyPayment = Math.round(amountRemaining/60*100)/100;
        createFinancesPlan(offer.getCustomerId(), offer.getCarId(), amountRemaining, monthlyPayment, 0);
    }

    public void createFinancesPlan(int customerId, int carId, double amountRemaining, double monthlyPayment, int monthsPaid) {
        fdi.newFinancePlan(customerId, carId, amountRemaining, monthlyPayment, monthsPaid);
    }

    public Finances viewFinancesById(int customerId, int carId) {
        Finances finances = fdi.viewPlanByCustomerIdAndCarId(customerId, carId);
        return finances;
    }

    public Finances makePayment(Finances finances) {
        finances.setAmountRemaining(Math.round(finances.getAmountRemaining()*100)/100 - Math.round(finances.getMonthlyPayment()*100)/100);
        finances.setMonthsPaid(finances.getMonthsPaid() + 1);
        fdi.payBill(finances.getAmountRemaining(), finances.getMonthsPaid(), finances.getCustomerId(), finances.getCarId());
        fdi.viewPlanByCustomerIdAndCarId(finances.getCustomerId(), finances.getCarId());
        return finances;
    }

    public DealershipArrayList<Finances> viewAllPlans(){
        financeList = fdi.getAllPlans();
        return financeList;
    }


}
