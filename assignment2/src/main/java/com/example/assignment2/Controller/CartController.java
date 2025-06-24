package com.example.assignment2.Controller;

import com.example.assignment2.Entity.Cart;
import com.example.assignment2.Entity.CartItem;
import com.example.assignment2.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/user/{userId}")
    public Cart getCartByUserId(@PathVariable int userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void createCart(@PathVariable int userId) {
        cartService.createCart(userId);
    }

    @GetMapping("/{cartId}/items")
    public List<CartItem> getCartItems(@PathVariable int cartId) {
        return cartService.getItems(cartId);
    }

    @PostMapping("/item")
    public void addItem(@RequestBody CartItem item) {
        cartService.addItem(item);
    }

    @PutMapping("/item/{itemId}/quantity/{quantity}")
    public void updateItemQuantity(@PathVariable int itemId, @PathVariable int quantity) {
        cartService.updateQuantity(itemId, quantity);
    }

    @DeleteMapping("/item/{itemId}")
    public void removeItem(@PathVariable int itemId) {
        cartService.removeItem(itemId);
    }
}
