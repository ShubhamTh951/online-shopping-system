package com.yourname.onlineshop.cart;

import java.util.HashMap;
import java.util.Map;

import com.yourname.onlineshop.product.Product;

/*
 * Represents a shopping cart in the online shopping system.
 * The cart stores products along with their quantities and
 * provides operations to manage cart items.
*/
public class Cart {
    private Map<Product, Integer> cartItems;

    public Cart() {
        this.cartItems = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid product or quantity.");
            return;
        }

        if (!product.isAvailable()) {
            System.out.println("Product is not available.");
            return;
        }

        int existingQty = cartItems.getOrDefault(product, 0);
        cartItems.put(product, existingQty + quantity);
    }

    
    public void removeItem(Product product) {
        if (cartItems.remove(product) == null) {
            System.out.println("Product not found in cart.");
        }
    }

    
    public void updateQuantity(Product product, int quantity) {
        if (!cartItems.containsKey(product)) {
            System.out.println("Product not found in cart.");
            return;
        }

        if (quantity <= 0) {
            cartItems.remove(product);
        } else {
            cartItems.put(product, quantity);
        }
    }

    public double calculateTotalAmount() {
        double total = 0.0;

        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }

        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("----- Cart Items -----");
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getProductId() +
                    " | Qty: " + quantity +
                    " | Price: " + product.getPrice());
        }
        System.out.println("Total Amount: " + calculateTotalAmount());
    }
}
