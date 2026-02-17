package com.project.onlineshop.user;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Integer> orders;
    private double balance;

    public Customer(int userId, String name, String email, String password, String phone, String address, double balance) {
        super(userId, name, email, password, phone, address);
        this.orders = new ArrayList<>();
        this.balance = balance;
    }

    public void addOrder(int orderId) {
        orders.add(orderId);
    }

    public void viewOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (int id : orders) {
            System.out.println("Order ID: " + id);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void refund(double amount) {
        balance += amount;
    }

    public boolean deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
