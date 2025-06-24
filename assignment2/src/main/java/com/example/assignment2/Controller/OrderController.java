package com.example.assignment2.Controller;

import com.example.assignment2.Entity.Order;
import com.example.assignment2.Entity.OrderItem;
import com.example.assignment2.Service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable int userId) {
        return orderService.getByUserId(userId);
    }

    @GetMapping("/{orderId}/items")
    public List<OrderItem> getItemsByOrderId(@PathVariable int orderId) {
        return orderService.getItemsByOrderId(orderId);
    }
}