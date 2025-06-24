package com.example.assignment2.Entity;

import java.time.LocalDateTime;

public class Invoice {
    public int id;
    public int orderId;
    public LocalDateTime invoiceDate;
    public double totalAmount;
    public double discountApplied;
    public double finalAmount;

    public Invoice() {
    }

    public Invoice(int id, int orderId, LocalDateTime invoiceDate, double totalAmount, double discountApplied, double finalAmount) {
        this.id = id;
        this.orderId = orderId;
        this.invoiceDate = invoiceDate;
        this.totalAmount = totalAmount;
        this.discountApplied = discountApplied;
        this.finalAmount = finalAmount;
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

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
