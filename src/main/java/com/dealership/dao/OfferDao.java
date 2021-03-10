package com.dealership.dao;


import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;

public interface OfferDao {

    public int addOffer(double amountOffered, int customerId, int carId);
    public int removeOffer(int customerId, int carId);
    public int acceptOffer(int carId);
    public DealershipArrayList<Offer> viewOffersByCarId(int carId);
    public int offerByCarIdAndCustomerId(int customerId, int carId);
}
