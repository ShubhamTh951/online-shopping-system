package com.project.onlineshop.app;

import com.project.onlineshop.cart.Cart;
import com.project.onlineshop.payment.UPIPayment;
import com.project.onlineshop.product.Product;
import com.project.onlineshop.service.InventoryService;
import com.project.onlineshop.service.OrderService;
import com.project.onlineshop.user.Admin;
import com.project.onlineshop.user.Customer;

public class MainApp {

    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        Admin admin = new Admin(
                1,"Admin",
                "admin@mail.com",
                "1234",
                "9999",
                "India",
                "SUPER");
        
        Product laptop = new Product(
                101,"Laptop",
                "Gaming Laptop",
                60000,5,
                "Electronics");
        
        admin.addProduct(inventory, laptop);
        inventory.displayProducts();

        Customer customer = new Customer(
                    2,
                    "Shubham",
                    "user@mail.com",
                    "1111",
                    "8888",
                    "India",
                    100000);
        
        customer.login("user@mail.com", "1111");
        customer.updateProfile("999999999", "Delhi");
        customer.changePassword("1111", "2222");

        Cart cart = new Cart();
        cart.addItem(laptop, 1);
        cart.displayCart();

        UPIPayment payment = new UPIPayment("user@upi");

        OrderService orderService = new OrderService();
        var order = orderService .placeOrder(customer, cart, payment);

        if (order != null) {
            System.out.println("Order placed successfully!");
        } 
        else {
            System.out.println("Order Failed!");
        }

        customer.viewOrderHistory();
        orderService.displayAllOrders();

        customer.logout();
    }
}
