package com.project.onlineshop.product;

/*
  Represents a product in the online shopping system.
  This class stores product details and provides
  basic operations related to product management.
*/

public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
    private boolean isAvailable;

    public Product(int productId, String name, String description, double price, int stock, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.isAvailable = stock > 0;
    }

    public void updateStock(int quantity) {
        if (quantity < 0) {
            System.out.println("Stock cannot be negative.");
            return;
        }
        this.stock = quantity;
        this.isAvailable = quantity > 0;
    }

    public void markUnavailable() {
        this.isAvailable = false;
    }

    public void markAvailable() {
        if (stock > 0) {
            this.isAvailable = true;
        }
    }

    public void displayProductDetails() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Name         : " + name);
        System.out.println("Category     : " + category);
        System.out.println("Price        : " + price);
        System.out.println("Stock        : " + stock);
        System.out.println("Available    : " + (isAvailable ? "Yes" : "No"));
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }   
}
