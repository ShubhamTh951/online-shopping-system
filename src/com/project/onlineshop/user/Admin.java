package com.project.onlineshop.user;

import com.project.onlineshop.product.Product;
import com.project.onlineshop.service.InventoryService;
import com.project.onlineshop.service.OrderService;

public class Admin extends User {

    private String adminRole;

    public Admin(int userId, String name, String email,
                 String password, String phone,
                 String address, String adminRole) {

        super(userId, name, email, password, phone, address);
        this.adminRole = adminRole;
    }

    public void addProduct(Product product, InventoryService inventory) {

        try {

            inventory.addProduct(product);
            System.out.println("Product added successfully.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void removeProduct(int productId, InventoryService inventory) {

        try {

            if (inventory.removeProduct(productId)) {
                System.out.println("Product removed successfully.");
            } else {
                System.out.println("Product not found.");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void viewAllOrders(OrderService orderService) {

        try {

            orderService.displayAllOrders();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}