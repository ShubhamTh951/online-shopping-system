package com.project.onlineshop.service;

import com.project.onlineshop.cart.Cart;
import com.project.onlineshop.order.Order;
import com.project.onlineshop.payment.PaymentMethod;
import com.project.onlineshop.product.Product;
import com.project.onlineshop.user.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1000;

    public Order placeOrder(Customer customer, Cart cart, PaymentMethod paymentMethod) {
        if (!customer.isLoggedIn()) return null;

        if (cart.isEmpty()) return null;
        
        double total = cart.calculateTotalAmount();
        if (!customer.deductBalance(total)) return null;

        for (Map.Entry<Product, Integer> entry : cart.getCartItems().entrySet()) {
            if (!entry.getKey().reduceStock(entry.getValue())) {
                customer.refund(total);
                return null;
            }
        }

        boolean paymentSuccess = paymentMethod.pay(total);

        if (!paymentSuccess) {
            for (Map.Entry<Product, Integer> entry :cart.getCartItems().entrySet()) {
                entry.getKey().updateStock(entry.getKey().getStock() + entry.getValue());
            }

            customer.refund(total);
            return null;
        }

        Order order = new Order(++orderCounter, cart.getCartItems(), total);
        order.markPaid();
        orders.add(order);
        customer.addOrder(order.getOrderId());
        return order;
    }

    public void displayAllOrders() {
        for (Order order : orders) {
            System.out.println("Order ID: " +
                order.getOrderId() +
                " | Status: " +
                order.getOrderStatus()
            );
        }
    }
}
