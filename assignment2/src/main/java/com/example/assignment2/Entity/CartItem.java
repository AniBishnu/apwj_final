package com.example.assignment2.Entity;

public class CartItem {
    public int id;
    public int cartID;
    public int productID;
    public int quantity;

    public CartItem() {
    }

    public CartItem(int id, int cartID, int productID, int quantity) {
        this.id = id;
        this.cartID = cartID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
