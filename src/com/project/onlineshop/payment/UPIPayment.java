package com.project.onlineshop.payment;

import java.util.Random;

public class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0) return false;
        if (!upiId.contains("@")) return false;

        Random random = new Random();
        return random.nextInt(100) >= 20;
    }
}