package com.project.onlineshop.order;

import com.project.onlineshop.product.Product;
import java.util.Date;
import java.util.Map;

public class Order {

    private int orderId;
    private Map<Product, Integer> orderedItems;
    private double totalAmount;
    private Date orderDate;
    private OrderStatus orderStatus;

    public Order(int orderId, Map<Product, Integer> items, double total) {
        this.orderId = orderId;
        this.orderedItems = items;
        this.totalAmount = total;
        this.orderDate = new Date();
        this.orderStatus = OrderStatus.PLACED;
    }

    public void markPaid() {
        orderStatus = OrderStatus.PAID;
    }

    public void cancelOrder() {
        orderStatus = OrderStatus.CANCELLED;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
