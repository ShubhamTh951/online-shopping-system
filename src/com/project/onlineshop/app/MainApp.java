package com.project.onlineshop.app;

import com.project.onlineshop.cart.Cart;
import com.project.onlineshop.payment.PaymentMethod;
import com.project.onlineshop.payment.UPIPayment;
import com.project.onlineshop.product.Product;
import com.project.onlineshop.service.InventoryService;
import com.project.onlineshop.service.OrderService;
import com.project.onlineshop.user.Customer;
import com.project.onlineshop.dao.UserDAO;

import java.util.Map;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryService inventoryService = new InventoryService();
        OrderService orderService = new OrderService();

        Cart cart = new Cart();

        UserDAO userDAO = new UserDAO();

        Customer customer;

        try {

            customer = userDAO.findCustomerByEmail("shubham@gmail.com");

            if (customer == null) {

                System.out.println("User not found. Creating new user...");

                    Customer newCustomer = new Customer(
                            0,
                            "Shubham",
                            "shubham@gmail.com",
                            "1234",
                            "9999999999",
                            "India",
                            100000
            );

            customer = userDAO.saveCustomer(newCustomer);

            System.out.println("User created with ID: " + customer.getUserId());
            }

        } catch (Exception e) {

            e.printStackTrace();
            return;
        }

        while (true) {

            System.out.println("\n===== ONLINE SHOP =====");
            System.out.println("1. Add Product (Admin)");
            System.out.println("2. View Product");
            System.out.println("3. Add To Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1 -> {

                        System.out.println("Enter Product Name:");
                        String name = sc.next();

                        System.out.println("Description:");
                        String desc = sc.next();

                        System.out.println("Price:");
                        double price = sc.nextDouble();

                        System.out.println("Stock:");
                        int stock = sc.nextInt();

                        System.out.println("Category:");
                        String cat = sc.next();

                        Product product = new Product(
                                0,
                                name,
                                desc,
                                price,
                                stock,
                                cat
                        );

                        inventoryService.addProduct(product);

                        System.out.println("Product added successfully!");
                    }

                    case 2 -> {

                        System.out.println("Enter Product ID:");
                        int id = sc.nextInt();

                        Product p = inventoryService.findProductById(id);

                        if (p == null) {

                            System.out.println("Product not found.");

                        } else {

                            p.displayProductDetails();
                        }
                    }

                    case 3 -> {

                        System.out.println("Enter Product ID:");
                        int id = sc.nextInt();

                        Product p = inventoryService.findProductById(id);

                        if (p == null) {

                            System.out.println("Product not found.");
                            break;
                        }

                        System.out.println("Quantity:");
                        int qty = sc.nextInt();

                        boolean added = cart.addItem(p, qty);

                        if (added)
                            System.out.println("Added to cart");
                        else
                            System.out.println("Cannot add item");
                    }

                    case 4 -> cart.displayCart();

                    case 5 -> {

                        if (cart.isEmpty()) {

                            System.out.println("Cart empty.");
                            break;
                        }

                        PaymentMethod payment =
                                new UPIPayment("shubham@upi");

                        boolean success =
                                orderService.placeOrder(
                                        customer,
                                        cart.getCartItems(),
                                        payment
                                );

                        if (success) {

                            System.out.println("Order placed successfully!");

                            cart.clearCart();

                        } else {

                            System.out.println("Order failed.");
                        }
                    }

                    case 6 -> {

                        System.out.println("Goodbye!");
                        return;
                    }

                    default -> System.out.println("Invalid choice.");
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}