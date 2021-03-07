package com.dealership.dao;

import com.dealership.jdbc.ConnectionSession;
import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.util.DealershipArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferDaoImpl implements OfferDao{

    @Override
    public int addOffer(double amountOffered, int customerId, int carId) {
        String sql = "INSERT INTO offer_cars(customerId, carId, amountOffered)" +
                "VALUES (?, ?, ?)";
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ps.setInt(1, customerId);
            ps.setInt(2, carId);
            ps.setDouble(3, amountOffered);

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
        return 0;
    }

    @Override
    public int removeOffer(int customerId, int carId) {
        String sql = "DELETE FROM offer_cars where carId = " + carId + " and customerId = " + customerId;
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int acceptOffer(int carId) {
        String sql = "DELETE FROM offer_cars where carId = " + carId;
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {

            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public DealershipArrayList<Offer> viewOffersByCarId(int carId) {
        DealershipArrayList<Offer> offers = new DealershipArrayList<>();
        String sql = "SELECT * FROM offer_cars where carId = " + carId;
        try(
                ConnectionSession sess = new ConnectionSession();
                PreparedStatement ps = sess.getActiveConnection().prepareStatement(sql);)
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Offer offer = new Offer();
                offer.setCarId(rs.getInt("carId"));
                offer.setCustomerId(rs.getInt("customerId"));
                offer.setAmountOffered(rs.getDouble("amountOffered"));
                offers.add(offer);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return offers;
    }
}
