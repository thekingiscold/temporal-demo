package com.temporal.temporalDemo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestParam String orderId) {
        orderService.processOrder(orderId);
        return ResponseEntity.ok("Order " + orderId + " is being processed.");
    }

}
