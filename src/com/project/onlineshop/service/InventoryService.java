package com.project.onlineshop.service;

import java.util.ArrayList;
import java.util.List;

import com.project.onlineshop.product.Product;

public class InventoryService {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductById(int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
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
