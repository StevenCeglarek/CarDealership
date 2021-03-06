package com.dealership.dao;


import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;

public interface OfferDao {

    public int addOffer(double amountOffered, int customerId, int carId);
    public boolean removeOffer(int carId);
    public DealershipArrayList<Offer> viewOffersByCarId(int carId);
}
