package com.example.assignment2.Controller;

import com.example.assignment2.Entity.Wishlist;
import com.example.assignment2.Service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlistByUser(@PathVariable int userId) {
        return wishlistService.getWishlistByUserId(userId);
    }

    @PostMapping("/{userId}/add/{productId}")
    public void addToWishlist(@PathVariable int userId, @PathVariable int productId) {
        wishlistService.addProduct(userId, productId);
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public void removeFromWishlist(@PathVariable int userId, @PathVariable int productId) {
        wishlistService.removeProduct(userId, productId);
    }
}
