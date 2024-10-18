package com.temporal.temporalDemo.temporalConfig;

public class OrderActivitiesImpl implements OrderActivities {

    @Override
    public void validateOrder(String orderId) {
        // Simulate order validation
        System.out.println("Validating order: " + orderId);
    }

    @Override
    public void processPayment(String orderId) {
        // Simulate payment processing
        System.out.println("Processing payment for order: " + orderId);
    }

    @Override
    public void checkInventory(String orderId) {
        // Simulate inventory check
        System.out.println("Checking inventory for order: " + orderId);
    }

    @Override
    public void confirmOrder(String orderId) {
        // Simulate order confirmation
        System.out.println("Order " + orderId + " confirmed!");
    }
}
