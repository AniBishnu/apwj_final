package com.example.assignment2.Entity;

public class Wishlist {
    public int id;
    public int userId;
    public int productID;


    public Wishlist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Wishlist(int id, int userId, int productID) {
        this.id = id;
        this.userId = userId;
        this.productID = productID;
    }
}

