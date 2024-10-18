package com.temporal.temporalDemo.temporalConfig;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {
        // Connect to the Temporal service
        return WorkflowServiceStubs.newInstance();
    }

    @Bean
    public WorkflowClient workflowClient(WorkflowServiceStubs workflowServiceStubs) {
        // Create a workflow client for interacting with the Temporal service
        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public WorkerFactory workerFactory(WorkflowClient workflowClient) {
        // Create a worker factory to register workflows and activities
        return WorkerFactory.newInstance(workflowClient);
    }

    @Bean
    public Worker worker(WorkerFactory workerFactory) {
        // Register workers to poll workflows
        Worker worker = workerFactory.newWorker("ORDER_TASK_QUEUE");
        worker.registerWorkflowImplementationTypes(OrderWorkflowImpl.class); // Register your workflow implementation
        worker.registerActivitiesImplementations(new OrderActivitiesImpl()); // Register your activities
        workerFactory.start();
        return worker;
    }
}
