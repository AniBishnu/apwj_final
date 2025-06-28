package com.example.Vitascript.Entity;

import java.time.LocalDate;

public class Payment {
    public int id;
    public int saleId;           // FK to Sale
    public String method;        // "Cash", "Bkash", etc.
    public int amount;
    public LocalDate paymentDate;
    public String transactionId;

    public Payment(int id, int saleId, String method, int amount, String transactionId) {
        this.id = id;
        this.saleId = saleId;
        this.method = method;
        this.amount = amount;
        this.paymentDate = LocalDate.now();
        this.transactionId = transactionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
