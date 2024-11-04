package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.order.Item;
import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;
import com.example.demo.payment.Payment;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @PostMapping("/pay")
    public String payOrder(@RequestParam double amount, @RequestParam String paymentType) {
        Payment paymentStrategy;
        if ("creditcard".equalsIgnoreCase(paymentType)) {
            paymentStrategy = new CreditCardPaymentStrategy("1234567812345678");
        } else if ("paypal".equalsIgnoreCase(paymentType)) {
            paymentStrategy = new PayPalPaymentStrategy("test@example.com");
        } else {
            throw new IllegalArgumentException("Invalid payment type");
        }
        return paymentStrategy.pay(amount);
    }

    @PostMapping("/deliver")
    public String deliverOrder(@RequestBody List<Item> items, @RequestParam String deliveryType) {
        Delivery deliveryStrategy;
        if ("post".equalsIgnoreCase(deliveryType)) {
            deliveryStrategy = new PostDeliveryStrategy();
        } else if ("dhl".equalsIgnoreCase(deliveryType)) {
            deliveryStrategy = new DHLDeliveryStrategy();
        } else {
            throw new IllegalArgumentException("Invalid delivery type");
        }
        return deliveryStrategy.deliver(items);
    }
}
