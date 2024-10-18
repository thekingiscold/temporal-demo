package com.temporal.temporalDemo;

import com.temporal.temporalDemo.temporalConfig.OrderWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final WorkflowClient workflowClient;

    public OrderService(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    public void processOrder(String orderId) {
        OrderWorkflow workflow = workflowClient.newWorkflowStub(OrderWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("ORDER_TASK_QUEUE")
                        .build());

        // Start the workflow asynchronously
        WorkflowClient.start(workflow::processOrder, orderId);
    }
}
