package com.assignment.asnmt.Service;


import com.assignment.asnmt.Model.Product;
import com.assignment.asnmt.ProductCategory;
import com.assignment.asnmt.Repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(@NotNull Product product) {
        productRepository.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public List<Product> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        return productRepository.getAllProducts().stream()
                .filter( product-> !product.getExpiryDate().isBefore(today) && product.getExpiryDate().isBefore(today.plusDays(7))).collect(Collectors.toList());
    }

    public List<Product> applyDiscountToExpiringProducts(double discountPercent) {
        List<Product> expiredProduct = getExpiringSoon();

        expiredProduct.forEach(product -> product.price = product.price *discountPercent);

        return expiredProduct;
    }

    public List<Product> getProductsByCategoryWithDiscount(ProductCategory category, double discountPercent) {
        LocalDate today = LocalDate.now();

        return productRepository.getAllProducts().stream()
                .filter(product -> product.getCategory() == category)
                .peek(product -> {
                    if (product.getExpiryDate().isBefore(today)) {
                        product.available=false;
                    } else if (product.getExpiryDate().isBefore(today.plusDays(7))) {
                        product.setPrice(product.getPrice() * discountPercent);
                    }
                })
                .collect(Collectors.toList());
    }
    public void addProducts(List<Product> products) {
        for (Product product : products) {
            productRepository.addProduct(product);
        }
    }

}
