package com.project.onlineshop.service;

import java.util.ArrayList;
import java.util.List;

import com.project.onlineshop.order.Order;
import com.project.onlineshop.cart.Cart;
import com.project.onlineshop.user.Customer;

public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1000;

    public Order placeOrder(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return null;
        }

        Order order = new Order(++orderCounter, cart);
        orders.add(order);
        customer.addOrder(order.getOrderId());
        cart.clearCart();

        return order;
    }
}
