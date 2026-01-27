package com.project.onlineshop.user;

/*
    Represents an admin user responsible for managing
    products and overseeing orders
*/


public class Admin extends User {
    private String adminRole;

    public Admin(int userId, String name, String email, String password, String phone, String address) {
        super(userId, name, email, password, phone, address);
        this.adminRole = adminRole;
    }

    public void addProduct() {
        System.out.println("Product added by admin");
    }

    public void removeProduct() {
        System.out.println("Product removed by admin");
    }

    public void viewAllOrders() {
        System.out.println("Viewing all orders.");
    }
    
}