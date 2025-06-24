package com.example.assignment2.Entity;

public class OrderItem {
    public int id;
    public int orderId;
    public int productId;
    public int quantity;
    public double price;
    private double finalPrice;

    public OrderItem() {
    }



    public OrderItem(int orderId, int productId, int quantity, double price, double finalPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.finalPrice=finalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
