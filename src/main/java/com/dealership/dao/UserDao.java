package com.dealership.dao;

import com.dealership.model.User;

public interface UserDao {

    public boolean addUser(User user);
    public boolean updateUser(User user);
}
