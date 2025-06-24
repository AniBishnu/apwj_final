package com.example.assignment2.Service;

import com.example.assignment2.Entity.Order;
import com.example.assignment2.Entity.OrderItem;
import com.example.assignment2.Entity.Product;
import com.example.assignment2.Repository.OrderItemRepo;
import com.example.assignment2.Repository.OrderRepo;
import com.example.assignment2.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    private final ProductRepo productRepo;

    public ReportService(OrderRepo orderRepo, OrderItemRepo orderItemRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
        this.productRepo = productRepo;
    }

    public Map<String, Double> getSalesPerCategory() {
        List<Product> products = productRepo.getAll();
        List<OrderItem> items = orderItemRepo.getAll();

        Map<String, Double> sales = new HashMap<>();

        for (OrderItem item : items) {
            Product product = products.stream()
                    .filter(p -> p.getId() == item.getProductId())
                    .findFirst().orElse(null);

            if (product != null) {
                String category = product.getCategory().toString();
                double total = item.getFinalPrice() * item.getQuantity();
                sales.put(category, sales.getOrDefault(category, 0.0) + total);
            }
        }

        return sales;
    }

    public double getTotalRevenue() {
        List<Order> orders = orderRepo.getAll();
        return orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }

    public int getTotalOrderCount() {
        return orderRepo.getAll().size();
    }

    public List<Map.Entry<String, Integer>> getBestSellingProducts(int topN) {
        List<OrderItem> items = orderItemRepo.getAll();
        List<Product> products = productRepo.getAll();

        Map<Integer, Integer> quantitySoldMap = new HashMap<>();
        for (OrderItem item : items) {
            quantitySoldMap.put(
                    item.getProductId(),
                    quantitySoldMap.getOrDefault(item.getProductId(), 0) + item.getQuantity()
            );
        }

        Map<String, Integer> bestSellers = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : quantitySoldMap.entrySet()) {
            int productId = entry.getKey();
            Product product = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst().orElse(null);

            if (product != null) {
                bestSellers.put(product.getName(), entry.getValue());
            }
        }

        return bestSellers.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

}
