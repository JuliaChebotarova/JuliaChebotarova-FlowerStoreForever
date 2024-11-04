package com.example.demo.payment;

public class PayPalPaymentStrategy implements Payment {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using PayPal account " + email;
    }
}
