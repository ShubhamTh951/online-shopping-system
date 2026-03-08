package com.project.onlineshop.app;

import com.project.onlineshop.product.Product;
import com.project.onlineshop.service.InventoryService;

public class MainApp {

    public static void main(String[] args) {

        try {

            InventoryService inventory = new InventoryService();

            Product laptop =
                    new Product(0,
                            "Laptop",
                            "Gaming Laptop",
                            60000,
                            10,
                            "Electronics");

            inventory.addProduct(laptop);

            System.out.println("Product inserted successfully.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}