package com.example.assignment2.Service;

import com.example.assignment2.Entity.Wishlist;
import com.example.assignment2.Repository.WishlistRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {
    public WishlistRepo wishlistRepo;

    public WishlistService(WishlistRepo wishlistRepo) {
        this.wishlistRepo = wishlistRepo;
    }

    public List<Wishlist> getWishlistByUserId(int userId) {
        return wishlistRepo.getWishlistByUserId(userId);
    }

    public void addProduct(int userId, int productId) {
        wishlistRepo.addProductToWishlist(userId, productId);
    }

    public void removeProduct(int userId, int productId) {
        wishlistRepo.removeProductFromWishlist(userId, productId);
    }
}
