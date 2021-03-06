package com.dealership.dao;

import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferDaoImpl implements OfferDao{

    Connection connection = null;
    PreparedStatement stmt = null;
    @Override
    public int addOffer(double amountOffered, int customerId, int carId) {
        try {
            connection = DAOUtilities.getConnection();
            String sql = "INSERT INTO offer_cars(customerId, carId, amountOffered)" +
                    "VALUES (?, ?, ?)";
            Offer offer = new Offer(amountOffered);
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, customerId);
            stmt.setInt(2, carId);
            stmt.setDouble(3, offer.getAmountOffered());

            int i = stmt.executeUpdate();
            if (i != 0) {
                return i;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return 0;
    }

    @Override
    public boolean removeOffer(int carId) {
        return false;
    }

    @Override
    public DealershipArrayList<Offer> viewOffersByCarId(int carId) {
        DealershipArrayList<Offer> offers = new DealershipArrayList<>();

        try {
            connection = DAOUtilities.getConnection();
            String sql = "SELECT * FROM offer_cars where carId = " + carId;
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Offer offer = new Offer();

                offer.setAmountOffered(rs.getDouble("amountOffered"));
                offers.add(offer);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return offers;
    }

    private void closeResources() {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            System.out.println("Could not close statement!");
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close connection!");
            e.printStackTrace();
        }
    }
}
