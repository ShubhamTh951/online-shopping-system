package com.project.onlineshop.payment;

public class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of ₹" + amount + " successful via UPI: " + upiId);
        return true;
    }
}