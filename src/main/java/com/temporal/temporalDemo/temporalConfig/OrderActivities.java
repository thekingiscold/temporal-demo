package com.temporal.temporalDemo.temporalConfig;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface OrderActivities {

    @ActivityMethod
    void validateOrder(String orderId);

    @ActivityMethod
    void processPayment(String orderId);

    @ActivityMethod
    void checkInventory(String orderId);

    @ActivityMethod
    void confirmOrder(String orderId);
}
