package com.assignment.asnmt.Model;

import com.assignment.asnmt.ProductCategory;

import java.time.LocalDate;

public class Product {
    public int id;
    public String name;
    public ProductCategory category;
    public double price;
    public int quantity;
    public LocalDate expiryDate;
    public boolean available;

    public Product(int id, String name, ProductCategory category, double price, int quantity, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        if(quantity>0){available=true;}
        else {available=false;}


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
