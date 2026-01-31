package com.project.onlineshop.app;

import com.project.onlineshop.cart.Cart;
import com.project.onlineshop.payment.UPIPayment;
import com.project.onlineshop.product.Product;
import com.project.onlineshop.service.InventoryService;
import com.project.onlineshop.service.OrderService;
import com.project.onlineshop.user.Customer;

public class MainApp {

    public static void main(String[] args) {

        Customer customer = new Customer(
                1, "Shubham", "shubham@gmail.com",
                "1234", "9999999999", "India"
        );

        Product laptop = new Product(
                101, "Laptop", "Gaming Laptop",
                60000, 5, "Electronics"
        );

        InventoryService inventory = new InventoryService();
        inventory.addProduct(laptop);

        Cart cart = new Cart();
        cart.addItem(laptop, 1);
        cart.displayCart();

        OrderService orderService = new OrderService();
        var order = orderService.placeOrder(customer, cart);

        if (order != null) {
            UPIPayment payment = new UPIPayment("shubham@upi");
            payment.pay(order.getTotalAmount());
        }
    }
}
