package com.project.onlineshop.service;

import com.project.onlineshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int id) {
        return products.removeIf(p -> p.getProductId() == id);
    }

    public Product findProduct(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    public void displayProducts() {
        for (Product p : products) {
            p.displayProductDetails();
        }
    }
}
