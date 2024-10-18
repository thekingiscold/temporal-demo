package com.temporal.temporalDemo.temporalConfig;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;

public class OrderWorkflowImpl implements OrderWorkflow {

    private final OrderActivities activities = Workflow.newActivityStub(OrderActivities.class,
            ActivityOptions.newBuilder()
                    .setStartToCloseTimeout(Duration.ofSeconds(10))
                    .build());

    @Override
    public void processOrder(String orderId) {
        // Workflow logic
        activities.validateOrder(orderId);
        activities.processPayment(orderId);
        activities.checkInventory(orderId);
        activities.confirmOrder(orderId);
    }
}
