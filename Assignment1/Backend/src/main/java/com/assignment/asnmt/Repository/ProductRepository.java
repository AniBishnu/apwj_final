package com.assignment.asnmt.Repository;

import com.assignment.asnmt.Model.Product;
import com.assignment.asnmt.ProductCategory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    public static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Serum", ProductCategory.BeautyCare, 1800.00, 5, LocalDate.of(2025, 7, 28)));
        productList.add(new Product(2, "Chicken", ProductCategory.Meat, 500.00, 4, LocalDate.of(2025, 6, 20)));
        productList.add(new Product(3, "Capsicum", ProductCategory.Vegetables, 300.00, 50, LocalDate.of(2025, 7, 28)));
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(int id) {
        return productList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == updatedProduct.getId()) {
                productList.set(i, updatedProduct);
                return;
            }
        }
    }
}
