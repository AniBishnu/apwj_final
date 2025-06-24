package com.example.assignment2.Service;

import com.example.assignment2.Entity.Order;
import com.example.assignment2.Entity.OrderItem;
import com.example.assignment2.Repository.OrderItemRepo;
import com.example.assignment2.Repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public OrderRepo orderRepo;
    public OrderItemRepo orderItemRepo;

    public OrderService(OrderRepo orderRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }
    public List<Order> getAllOrders() {
        return orderRepo.getAll();
    }

    public List<Order> getByUserId(int userId) {
        return orderRepo.getByUserId(userId);
    }

    public void createOrder(Order order) {
        orderRepo.createOrder(order);
    }

    public void addOrderItem(OrderItem item) {
        orderItemRepo.addItem(item);
    }

    public List<OrderItem> getItemsByOrderId(int orderId) {
        return orderItemRepo.getItemsByOrderId(orderId);
    }
}
