package com.dealership.dao;

import com.dealership.jdbc.ConnectionSession;
import com.dealership.model.Finances;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinancesDaoImpl implements FinancesDao{
    @Override
    public int newFinancePlan(int customerId, int carId, double amountRemaining, double monthlyPayment, int monthsPaid) {
        String sql = "INSERT INTO finance_plan(customerId, carId, amountRemaining, monthlyPayment, monthsPaid)" +
                "VALUES (?, ?, ?, ?, ?)";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {

            ps.setInt(1, customerId);
            ps.setInt(2, carId);
            ps.setDouble(3, amountRemaining);
            ps.setDouble(4, monthlyPayment);
            ps.setInt(5, monthsPaid);
            int i = ps.executeUpdate();
            if (i != 0) {
                return i;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Finances viewPlanByCustomerIdAndCarId(int customerId, int carId) {
        Finances finances = null;
        String sql = "SELECT * FROM finance_plan WHERE customerId = " + customerId + " and carId = " + carId;
        try (
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                finances = new Finances();

                finances.setCustomerId(rs.getInt("customerId"));
                finances.setCarId(rs.getInt("carId"));
                finances.setAmountRemaining(rs.getDouble("amountRemaining"));
                finances.setMonthlyPayment(rs.getDouble("monthlyPayment"));
                finances.setMonthsPaid(rs.getInt("monthsPaid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finances;
    }

    @Override
    public int payBill(double amountPaid) {
        return 0;
    }

    @Override
    public int completePlan(int carId) {
        return 0;
    }
}
