package com.example.assignment2.Service;

import com.example.assignment2.Entity.Product;
import com.example.assignment2.Repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    public ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getAll() {
        return productRepo.getAll();
    }

    public Product getById(int id) {
        return productRepo.getById(id);
    }

    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteProduct(id);
    }

    public List<Product> getExpiringSoon() {
        return productRepo.getAll().stream()
                .filter(p -> p.getExpiryDate() != null &&
                        !p.getExpiryDate().isBefore(LocalDate.now()) &&
                        p.getExpiryDate().isBefore(LocalDate.now().plusDays(7)))
                .collect(Collectors.toList());
    }

    public boolean isNearExpiry(Product product) {
        return product.getExpiryDate() != null &&
                !product.getExpiryDate().isBefore(LocalDate.now()) &&
                product.getExpiryDate().isBefore(LocalDate.now().plusDays(7));
    }

}
