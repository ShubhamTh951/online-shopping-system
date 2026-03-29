package com.project.onlineshop.payment;


public class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0) return false;
        if (!upiId.contains("@")) return false;
        System.out.println("Payment of ₹" + amount + " successful via UPI: " + upiId);

        return true;
    }
}