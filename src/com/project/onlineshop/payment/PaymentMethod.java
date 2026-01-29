package com.project.onlineshop.payment;

/*
  Interface for different payment methods.
*/
public interface PaymentMethod {
    boolean pay(double amount);
}

