package com.project.onlineshop.user

import java.util.ArrayList;
import java.util.List;

/*
    Represent a customer in the system.
    A customer can place orders and view order history.
*/

public class Customer extends User {
    private List<String> orders;

    public Customer(int userId, String name, String email, String password, String phone, String address) {
        super(userId, name, email, password, phone, address);
        this.orders = new ArrayList<>();
    }

    public void addOrder(String orderId) {
        orders.add(orderId);
    }

    public void viewOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (String order : orders) {
            System.out.println("Order ID: " + order);
        }
    }
}
