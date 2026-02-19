package com.project.onlineshop.user;

import com.project.onlineshop.product.Product;
import com.project.onlineshop.service.InventoryService;
import com.project.onlineshop.service.OrderService;

public class Admin extends User {
    private String adminRole;

    public Admin(int userId, String name, String email, String password, String phone, String address, String adminRole) {
        super(userId, name, email, password, phone, address);
        this.adminRole = adminRole;
    }

    public void addProduct(InventoryService inventory, Product product) {
        inventory.addProduct(product);
        System.out.println("Product added by admin");
    }

    public void removeProduct(InventoryService inventory, int productId) {
        if (inventory.removeProduct(productId)) {
            System.out.println("Product removed by admin");
        } else {
            System.out.println("Product not found");
        }
    }

    public void viewAllOrders(OrderService orderService) {
        orderService.displayAllOrders();
    }
    
}