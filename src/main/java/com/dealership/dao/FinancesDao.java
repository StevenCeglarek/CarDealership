package com.dealership.dao;

import com.dealership.model.Finances;

public interface FinancesDao {

    public int newFinancePlan(int customerId, int carId, double amountRemaining, double monthlyPayment, int monthsPaid);
    public int payBill(double amountPaid);
    public int completePlan(int carId);
    public Finances viewPlanByCustomerIdAndCarId(int customerId, int carId);
}
