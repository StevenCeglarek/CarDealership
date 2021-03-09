package com.dealership.dao;

import com.dealership.model.Finances;
import com.dealership.util.DealershipArrayList;

public interface FinancesDao {

    public int newFinancePlan(int customerId, int carId, double amountRemaining, double monthlyPayment, int monthsPaid);
    public int payBill(double amountPaid, int newMonthsPaid, int customerId, int carId);
    public int completePlan(int carId);
    public Finances viewPlanByCustomerIdAndCarId(int customerId, int carId);
    public DealershipArrayList<Finances> getAllPlans();
}
