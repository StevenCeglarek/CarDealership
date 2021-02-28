package com.dealership.services;

import com.dealership.model.User;

import java.util.ArrayList;

public class UserService {

    public static ArrayList<User> users = new ArrayList<User>();
    private static int currentIndex = 0;

    public boolean doesUsernameExist(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsername(username) != null;
    }

    public User findUserByUsername(String username){
        // O(n) time complexity O(1) space complexity
        if(currentIndex > 0) {
            for (int i = 0; i <= currentIndex; i++) {
                if (users.get(i).getUsername().equals(username)) {
                    return users.get(i);
                }
            }
        }
        return null;
    }

    public boolean registerEmployeeOrCustomer(String passcode, String username) {
        User us = findUserByUsername(username);
        if (passcode.equals("12345")) {
            us.setEmployee(true);
        } else if (passcode.equals("11111")) {
            us.setCustomer(true);
        } else {
            System.out.println("Incorrect Passcode, please try again.");
        }
        return false;
    }

    public boolean makeUser(String username, String password, String email,
                            String phoneNumber) {
        if(!doesUsernameExist(username)){
            users.add(new User(username, password, phoneNumber, email));
            currentIndex++;
            return true;
        } else {
            System.out.println("user already exists");
        }
        return false;
    }


}
