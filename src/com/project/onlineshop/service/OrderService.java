package com.project.onlineshop.service;

import com.project.onlineshop.dao.*;
import com.project.onlineshop.payment.PaymentMethod;
import com.project.onlineshop.product.Product;
import com.project.onlineshop.user.Customer;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    private ProductDAO productDAO = new ProductDAO();
    private UserDAO userDAO = new UserDAO();
    private OrderDAO orderDAO = new OrderDAO();

    public boolean placeOrder(Customer customer,
                              Map<Product, Integer> cartItems,
                              PaymentMethod payment) throws Exception {

        double total = 0;

        Map<Integer, Integer> productMap = new HashMap<>();

        for (var entry : cartItems.entrySet()) {

            Product product = productDAO.findById(entry.getKey().getProductId());

            if (product.getStock() < entry.getValue())
                return false;

            total += product.getPrice() * entry.getValue();

            productMap.put(product.getProductId(), entry.getValue());
        }

        if (!payment.pay(total))
            return false;

        if (!customer.deductBalance(total))
            return false;

        userDAO.updateBalance(customer.getUserId(), customer.getBalance());

        orderDAO.createOrder(customer.getUserId(), total, productMap);

        for (var entry : productMap.entrySet()) {

            Product p = productDAO.findById(entry.getKey());
            productDAO.updateStock(entry.getKey(),
                    p.getStock() - entry.getValue());
        }

        return true;
    }

    public void displayAllOrders() throws Exception {
        orderDAO.displayAllOrders();
    }
}