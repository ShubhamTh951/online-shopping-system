package com.project.onlineshop.cart;

import com.project.onlineshop.product.Product;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public boolean addItem(Product product, int quantity) {

        if (product == null || quantity <= 0) return false;
        if (!product.isAvailable()) return false;

        int existing = cartItems.getOrDefault(product, 0);

        if (product.getStock() < existing + quantity)
            return false;

        cartItems.put(product, existing + quantity);
        return true;
    }

    public void removeItem(Product product) {
        cartItems.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {

        if (!cartItems.containsKey(product)) return;

        if (quantity <= 0)
            cartItems.remove(product);
        else
            cartItems.put(product, quantity);
    }

    public double calculateTotalAmount() {

        double total = 0;

        for (var entry : cartItems.entrySet()) {
            total += entry.getKey().getPrice() *
                    entry.getValue();
        }
        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public Map<Product, Integer> getCartItems() {
        return new HashMap<>(cartItems);
    }

    public void displayCart() {

        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (var entry : cartItems.entrySet()) {
            System.out.println(entry.getKey().getProductId() + " | Qty: " +
                        entry.getValue());
        }

        System.out.println("Total: ₹" + calculateTotalAmount());
    }

    public void clearCart() {
        cartItems.clear();
    }
}
