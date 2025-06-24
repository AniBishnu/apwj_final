package com.example.assignment2.Service;

import com.example.assignment2.Entity.Cart;
import com.example.assignment2.Entity.CartItem;
import com.example.assignment2.Repository.CartItemRepo;
import com.example.assignment2.Repository.CartRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    public CartRepo cartRepo;
    public CartItemRepo cartItemRepo;

    public CartService(CartRepo cartRepo, CartItemRepo cartItemRepo) {
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
    }

    public Cart getCartByUserId(int userId) {
        return cartRepo.getCartByUserId(userId);
    }

    public void createCart(int userId) {
        cartRepo.createCart(userId);
    }

    public List<CartItem> getItems(int cartId) {
        return cartItemRepo.getByCartId(cartId);
    }

    public void addItem(CartItem item) {
        cartItemRepo.addCartItem(item);
    }

    public void updateQuantity(int itemId, int quantity) {
        cartItemRepo.updateQuantity(itemId, quantity);
    }

    public void removeItem(int itemId) {
        cartItemRepo.removeCartItem(itemId);
    }
}
