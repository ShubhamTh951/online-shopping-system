package com.project.onlineshop.order;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.project.onlineshop.cart.Cart;
import com.project.onlineshop.product.Product;

/*
  Represents an order placed by a customer.
  Once created, an order is independent of the cart.
*/
public class Order {

    private int orderId;
    private Map<Product, Integer> orderedItems;
    private double totalAmount;
    private Date orderDate;
    private String orderStatus;

    public Order(int orderId, Cart cart) {
        this.orderId = orderId;
        this.orderedItems = new HashMap<>(cart.getCartItems());
        this.totalAmount = cart.calculateTotalAmount();
        this.orderDate = new Date();
        this.orderStatus = "PLACED";
    }

    public void cancelOrder() {
        if (!orderStatus.equals("PLACED")) {
            System.out.println("Order cannot be cancelled.");
            return;
        }
        orderStatus = "CANCELLED";
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
